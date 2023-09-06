/**
 * 
 */
package com.zlennon.factory.factorymethod;

/**
 * @author zlennon
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FactoryBWM520LI bwm520li =new FactoryBWM520LI();
		System.out.println(bwm520li.createBWM().getName());
		FactoryBWM525LI bwm525li = new FactoryBWM525LI();
		System.out.println(bwm525li.createBWM().getName());
	}

}
