/**
 * 
 */
package com.zlennon.adapter.objectdapter;

import com.zl.instances.designpattern.adapter.classadapter.DrawCircle;
import com.zl.instances.designpattern.adapter.classadapter.DrawRcetangle;

/**
 * @author zlennon
 *
 */
public class ObjectAdapter implements DrawCircle {
		DrawRcetangle drawRcetangle;
		public ObjectAdapter(DrawRcetangle drawRcetangle) {
			this.drawRcetangle = drawRcetangle;
		}
	/* (non-Javadoc)
	 * @see com.zl.instances.designpattern.adapter.classadapter.DrawCircle#DrawCircle()
	 */
	@Override
	public String DrawCircle() {
		// TODO Auto-generated method stub
		return "Circle";
	}

}
