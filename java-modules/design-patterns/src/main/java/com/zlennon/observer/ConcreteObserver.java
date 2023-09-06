package com.zlennon.observer;

public class ConcreteObserver implements IObserver{
	private String name;
	public ConcreteObserver(String name) {
		this.setName(name);
	}
	@Override
	public String accept(String str) {
		// TODO Auto-generated method stub
		return str;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
