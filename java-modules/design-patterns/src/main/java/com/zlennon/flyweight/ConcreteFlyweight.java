package com.zlennon.flyweight;

public class ConcreteFlyweight extends Flyweight {
	private String s;

	public ConcreteFlyweight(String str) {
		this.s = str;
	}

	@Override
	public void flyweight() {
		System.out.println("ConcreteFlyweight:" + s);
	}

}
