package com.zlennon.observer;

public interface ISubject {

	 public void attach(ConcreteObserver o);
	 public void detach(ConcreteObserver o);
	 public void sendMessage(String s);
}
