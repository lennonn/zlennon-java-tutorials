/**
 * 
 */
package com.zlennon.decorator;

/**
 * @author zlennon
 *
 */
//装饰着
public abstract class Decorator implements Human {
        Human human;
        public Decorator(Human human){
        	this.human =human;
        }
		@Override
		public void wearClothes() {
		      human.wearClothes();
		}
		@Override
		public void walkToWhere() {
			human.walkToWhere();
		}
        
}
