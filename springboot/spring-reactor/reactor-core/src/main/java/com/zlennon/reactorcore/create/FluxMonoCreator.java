package com.zlennon.reactorcore.create;

import com.zlennon.reactorcore.MyEventListener;
import com.zlennon.reactorcore.MyEventProcessor;
import com.zlennon.reactorcore.MyMessageProcessor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class FluxMonoCreator {

    private final MyEventProcessor myEventProcessor;

    private final MyMessageProcessor myMessageProcessor;

    public FluxMonoCreator(MyEventProcessor myEventProcessor, MyMessageProcessor myMessageProcessor) {
        this.myEventProcessor = myEventProcessor;
        this.myMessageProcessor = myMessageProcessor;
    }


    public Flux<String> createFluxUseIterable(){
        List<String> iterable = Arrays.asList("foo", "bar", "foobar");
        return Flux.fromIterable(iterable);
    }

    public Flux<String> createFluxUseJust(){
        return Flux.just("foo", "bar", "foobar");
    }

    public Mono<String> createMonoUseJust(){
        return  Mono.just("foo");
    }

/*    public void fluxCleanupOncomplete(Channel channel){
       return  Flux.create(sink -> {
            sink.onRequest(n -> channel.poll(n))
                    .onCancel(() -> channel.cancel())
                    .onDispose(() -> channel.close())
        });
    }*/


    public Flux<String> createFluxUseGenerate(){
        return Flux.generate(
                () -> 0,
                (state, sink) -> {
                    sink.next("3 x " + state + " = " + 3*state);
                    if (state == 10) sink.complete();
                    return state + 1;
                });
    }

    public Flux<String> createFluxUseGenerateContainConsumer(){
        return Flux.generate(
                AtomicLong::new,
                (state, sink) -> {
                    long i = state.getAndIncrement();
                    sink.next("3 x " + i + " = " + 3*i);
                    if (i == 10) sink.complete();
                    return state;
                }, (state) -> System.out.println("state: " + state));
    }

    public Flux<String> createFluxUseBridge(){
        return Flux.create(sink -> {
            myEventProcessor.register(
                    new MyEventListener<String>() {

                        public void onDataChunk(List<String> chunk) {
                            for(String s : chunk) {
                                sink.next(s);
                            }
                        }

                        public void processComplete() {
                            sink.complete();
                        }
                    });
        });
    }

    public Flux<String> createFluxUseHybrid(){
        return Flux.create(sink -> {
            myMessageProcessor.register(
                    messages -> {
                        for(String s : messages) {
                            sink.next(s);
                        }
                    });
            sink.onRequest(n -> {
                List<String> messages = myMessageProcessor.getHistory(n);
                for(String s : messages) {
                    sink.next(s);
                }
            });
        });
    }

    public Flux<String> fluxFromIterable(){
        List<String> eles = List.of("A", "B", "C", "D");
        return  Flux.fromIterable(eles);
    }

    public Flux<String> createFluxAlphabet(){
        return Flux.just(-1, 30, 13, 9, 20)
                .handle((i, sink) -> {
                    String letter = alphabet(i);
                    if (letter != null)
                        sink.next(letter);
                });
    }

    public String alphabet(int letterNumber) {
        if (letterNumber < 1 || letterNumber > 26) {
            return null;
        }
        int letterIndexAscii = 'A' + letterNumber - 1;
        return "" + (char) letterIndexAscii;
    }


}
