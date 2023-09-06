/**
 * 
 */
package com.zlennon.factory.abstractfactory;

/**
 * @author zlennon
 *
 */
public class BWM525LIEngine implements Engine {
	public  BWM525LIEngine(){
		createEngine();
	}
	/* (non-Javadoc)
	 * @see com.zl.instances.designpattern.factory.abstractfactory.Engine#createEngine()
	 */
	@Override
	public void createEngine() {
		System.out.println("create engine bwm525li");
	}

}
