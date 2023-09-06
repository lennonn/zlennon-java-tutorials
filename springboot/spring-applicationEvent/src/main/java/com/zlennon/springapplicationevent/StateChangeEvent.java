package com.zlennon.springapplicationevent;

import lombok.Data;
import org.springframework.context.ApplicationEvent;



public class StateChangeEvent<T> extends ApplicationEvent {

    private  T data;
    public StateChangeEvent(T source) {
        super(source);
        this.data=source;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
