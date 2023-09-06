package com.zlennon.observer;

import java.util.ArrayList;
import java.util.List;

public class ConcreteSubject implements ISubject {
	private String name;
	private List<ConcreteObserver> observers=new ArrayList<ConcreteObserver>();
	public ConcreteSubject(String name){
		this.name=name;
	}
	@Override
	public void attach(ConcreteObserver o) {
		// TODO Auto-generated method stub
		observers.add(o);
		System.out.println("add"+" "+o.getName());
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public void detach(ConcreteObserver o) {
		// TODO Auto-generated method stub
		System.out.println("delete");
	}

	@Override
	public void sendMessage(String s) {
		System.out.println(observers.size());
		for(ConcreteObserver cobserver :observers){
			String string=cobserver.accept(s);
			System.out.println(string+" to "+cobserver.getName());
		}

	}




}
