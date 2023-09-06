/**
 * 
 */
package com.zlennon.adapter.interfaceadapter;

/**
 * @author zlennon
 *
 */
public class DefaultAdapter implements IDraw {

	/* (non-Javadoc)
	 * @see com.zl.instances.designpattern.adapter.interfaceadapter.IDraw#drawRectangel()
	 */
	@Override
	public String drawRectangel() {
		// TODO Auto-generated method stub
		return "Rectangle";
	}

	/* (non-Javadoc)
	 * @see com.zl.instances.designpattern.adapter.interfaceadapter.IDraw#drawCircle()
	 */
	@Override
	public String drawCircle() {
		// TODO Auto-generated method stub
		return "Circle";
	}

}
