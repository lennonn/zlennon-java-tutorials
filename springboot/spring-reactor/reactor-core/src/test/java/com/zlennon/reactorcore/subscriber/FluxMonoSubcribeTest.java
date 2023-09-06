package com.zlennon.reactorcore.subscriber;


import com.zlennon.reactorcore.ReactorCoreApplication;
import com.zlennon.reactorcore.ThreadingAndSchedulers;
import com.zlennon.reactorcore.create.FluxMonoCreator;
import com.zlennon.reactorcore.errorshandle.ExceptionHandling;
import com.zlennon.reactorcore.errorshandle.RetryHandling;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;

@SpringBootTest(classes = ReactorCoreApplication.class)
@RunWith(SpringRunner.class)
public class FluxMonoSubcribeTest {
    @Autowired
    FluxMonoSubcriber fluxMonoSubcribe;
    @Autowired
    FluxMonoCreator fluxMonoCreator;
    @Autowired
    SampleSubscriber sampleSubscriber;

    @Autowired
    ExceptionHandling exceptionHandling;

    @Autowired
    ThreadingAndSchedulers threadingAndSchedulers;

    @Autowired
    RetryHandling retryHandling;


    @Test
    public void testSubscribeFlux(){
        fluxMonoSubcribe.subscribeFlux();
    }
    @Test
    public void testSubscribeMono(){
        fluxMonoSubcribe.subscribeMono();
    }

    @Test
    public void testSimpleSubscribe(){
        Flux<String> fluxUseIterable = fluxMonoCreator.createFluxUseIterable();
        fluxUseIterable.subscribe(sampleSubscriber);
    }

    @Test
    public void testCreateFluxUseGenerate(){
        Flux<String> fluxUseGenerate = fluxMonoCreator.createFluxUseGenerate();
        fluxUseGenerate.subscribe(s-> System.out.println(s));
    }

    @Test
    public void testCreateFluxUseGenerateContainConsumer(){
        Flux<String> fluxUseGenerate = fluxMonoCreator.createFluxUseGenerateContainConsumer();
        fluxUseGenerate.subscribe(s-> System.out.println(s));
    }


    @Test
    public void testCreateFluxUseGenerateBridge(){
        Flux<String> fluxUseGenerateBridge = fluxMonoCreator.createFluxUseBridge();
        fluxUseGenerateBridge.subscribe(s-> System.out.println(s));
    }
    @Test
    public void testAlphabetSubscribe(){
        fluxMonoSubcribe.alphabetSubscribe();
    }

    @Test
    public void testThreadOfMono() throws InterruptedException {
        threadingAndSchedulers.threadOfMono();
    }

    @Test
    public void testUseSchedulersOnFlux() throws InterruptedException {
        threadingAndSchedulers.useSchedulersOnFlux();
        threadingAndSchedulers.schedulersOnFluxSubscribeOn();
    }


    @Test
    public void testHandleException() throws InterruptedException {
        exceptionHandling.handleException();
    }

    @Test
    public void testRetryHandling() throws InterruptedException {
        retryHandling.retryNTimes(3);
    }
    @Test
    public void testSinkHandle() throws InterruptedException {
        retryHandling.retryNTimes(3);
    }



}
