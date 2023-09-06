package com.zlennon.reactorcore.sinks;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

import java.time.Duration;

public class SinksHandle {

    public void sinkHandle(){
        Sinks.Many<Integer> replaySink = Sinks.many().replay().all();
//thread1
        replaySink.emitNext(1, Sinks.EmitFailureHandler.FAIL_FAST);

//thread2, later
        replaySink.emitNext(2, Sinks.EmitFailureHandler.FAIL_FAST);

//thread3, concurrently with thread 2
//would retry emitting for 2 seconds and fail with EmissionException if unsuccessful
        replaySink.emitNext(3, Sinks.EmitFailureHandler.busyLooping(Duration.ofSeconds(2)));

//thread3, concurrently with thread 2
//would return FAIL_NON_SERIALIZED
        Sinks.EmitResult result = replaySink.tryEmitNext(4);

        Flux<Integer> fluxView = replaySink.asFlux();
        fluxView
                .takeWhile(i -> i < 10)
                .log()
                .blockLast();
    }

}
