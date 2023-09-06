/**
 * 
 */
package com.zlennon.factory.abstractfactory;

/**
 * @author zlennon
 *
 */
public class BWM525LIFactory implements BWMFactory {

	/* (non-Javadoc)
	 * @see com.zl.instances.designpattern.factory.abstractfactory.BWMFactory#createEngine()
	 */
	@Override
	public Engine createEngine() {
		// TODO Auto-generated method stub
		return new BWM525LIEngine();
	}

	/* (non-Javadoc)
	 * @see com.zl.instances.designpattern.factory.abstractfactory.BWMFactory#createAriCondition()
	 */
	@Override
	public AriCondition createAriCondition() {
		// TODO Auto-generated method stub
		return new AirBWM525LI();
	}

}
