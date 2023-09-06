/**
 * 
 */
package com.zlennon.decorator;

/**
 * @author zlennon
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Human human  = new People();
		Decorator decorator = new Decorator_second(new Decorator_first(human));
		decorator.wearClothes();
		decorator.walkToWhere();
	}

}
