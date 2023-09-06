/**
 * 
 */
package com.zlennon.factory.factorymethod;

/**
 * @author zlennon
 *
 */
public class FactoryBWM520LI implements FactoryBWM {

	/* (non-Javadoc)
	 * @see com.zl.instances.designpattern.factory.factorymethod.FactoryBWM#createBWM()
	 */
	@Override
	public BWM createBWM() {
		
		return new BWM520Li("BWM520LI");
	}

}
