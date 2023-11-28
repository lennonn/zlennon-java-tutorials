/**
 * 
 */
package com.zlennon.factory.factorymethod;

/**
 * @author zlennon
 *
 */
public  abstract class BWM {
		public String getName() {
		return name;
	}
		public void setName(String name) {
		this.name = name;
	}
		private String name;
		public BWM(String name){
			this.name=name;
		}
}
