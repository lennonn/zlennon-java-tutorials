/**
 * 
 */
package com.zlennon.factory.abstractfactory;

/**
 * @author zlennon
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BWM520LIFactory bwm520liFactory = new BWM520LIFactory();
		bwm520liFactory.createAriCondition();
		bwm520liFactory.createEngine();
		BWM525LIFactory bwm525liFactory = new BWM525LIFactory();
		bwm525liFactory.createAriCondition();
		bwm525liFactory.createEngine();
		
	}

}
