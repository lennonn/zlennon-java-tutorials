package com.zlennon.reactorcore;

import java.util.List;

public interface MyMessageListener<T> {
     void onMessage(List<T> messages);
}
