/**
 * 
 */
package com.zlennon.factory.abstractfactory;

/**
 * @author zlennon
 *
 */
public class AirBWM520LI implements AriCondition {
	
	public AirBWM520LI(){
		createAriCondition();
	}
	/* (non-Javadoc)
	 * @see com.zl.instances.designpattern.factory.abstractfactory.AriCondition#createAriCondition()
	 */
	@Override
	public void createAriCondition() {
		System.out.println("create ari-conditon bwm520li");
	}

}
