package com.zlennon.springapplicationevent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class ContextStateChangeListener implements ApplicationListener<StateChangeEvent> {


    @Override
    public void onApplicationEvent(StateChangeEvent stateChangeEvent) {
        log.info("onApplicationEvent 状态改变==>>{}",stateChangeEvent.getData());
    }
}
