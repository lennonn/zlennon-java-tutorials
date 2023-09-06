/**
 * 
 */
package com.zlennon.factory.factorymethod;

/**
 * @author zlennon
 *
 */
public class FactoryBWM525LI implements FactoryBWM {

	/* (non-Javadoc)
	 * @see com.zl.instances.designpattern.factory.factorymethod.FactoryBWM#createBWM()
	 */
	@Override
	public BWM createBWM() {
		// TODO Auto-generated method stub
		return new BWM525Li("BWM525LI");
	}

}
