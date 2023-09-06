/**
 * 
 */
package com.zlennon.decorator;

/**
 * @author zlennon
 *
 */
public class Decorator_first extends Decorator {

	/**
	 * @param human
	 */
	public Decorator_first(Human human) {
		super(human);
	}
	
	public void goClothespress() {  
        System.out.println("去衣柜找找看。。");  
    }  
  
    public void findPlaceOnMap() {  
        System.out.println("在Map上找找。。");  
    }

	@Override
	public void wearClothes() {
		super.wearClothes();
		goClothespress() ;
	}

	@Override
	public void walkToWhere() {
		// TODO Auto-generated method stub
		super.walkToWhere();
		findPlaceOnMap();
	}  
  

}
