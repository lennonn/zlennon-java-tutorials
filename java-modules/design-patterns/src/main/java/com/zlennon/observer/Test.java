package com.zlennon.observer;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcreteSubject subject=new ConcreteSubject("subject1");
		ConcreteObserver observer1=new ConcreteObserver("observer1");
		observer1.setName("observer1");
		ConcreteObserver observer2=new ConcreteObserver("observer2");
		observer2.setName("observer2");
		ConcreteObserver observer3=new ConcreteObserver("observer3");
		observer3.setName("observer3");
		subject.attach(observer1);
		subject.attach(observer2);
		subject.attach(observer3);
		subject.sendMessage("subject is send Message");
	}

}
