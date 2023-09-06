/**
 * 
 */
package com.zlennon.decorator;

/**
 * @author zlennon
 *
 */
public  class Decorator_second extends Decorator {

	/**
	 * @param human
	 */
	public Decorator_second(Human human) {
		super(human);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void wearClothes() {
		// TODO Auto-generated method stub
		super.wearClothes();
		findClothes();
	}

	@Override
	public void walkToWhere() {
		// TODO Auto-generated method stub
		super.walkToWhere();
		findDestination();
	}
	
	public void findClothes(){
		System.out.println("找到一件T血");
	}
	public void findDestination(){
		System.out.println("找到一家电影院");
	}
	
}
