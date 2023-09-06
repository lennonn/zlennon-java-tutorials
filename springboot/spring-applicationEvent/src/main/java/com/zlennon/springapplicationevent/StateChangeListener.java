package com.zlennon.springapplicationevent;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class StateChangeListener {

    @EventListener
    public void stateListener(StateChangeEvent<State> stateChangeEvent){
        log.info("stateListener 状态改变==>>{}",stateChangeEvent.getData());
    }
}
