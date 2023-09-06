/**
 * 
 */
package com.zlennon.factory.abstractfactory;

/**
 * @author zlennon
 *
 */
public class BWM520LIFactory implements BWMFactory {

	/* (non-Javadoc)
	 * @see com.zl.instances.designpattern.factory.abstractfactory.BWMFactory#createEngine()
	 */
	@Override
	public Engine createEngine() {
		// TODO Auto-generated method stub
		return new BWM520LIEngine();
	}

	/* (non-Javadoc)
	 * @see com.zl.instances.designpattern.factory.abstractfactory.BWMFactory#createAriCondition()
	 */
	@Override
	public AriCondition createAriCondition() {
		return new AirBWM520LI();
	}

}
