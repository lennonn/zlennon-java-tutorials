package com.zlennon.extend;

public class Employee extends Person {
	String empID="000";

	public Employee(String id) {
		super(id);

		System.out.println(empID);
	}

	public static void main(String[] args) {
		Person person =new Employee("222");

	}
}
