/**
 * 
 */
package com.zlennon.adapter.objectdapter;

import com.zl.instances.designpattern.adapter.classadapter.DrawRcetangle;

/**
 * @author zlennon
 *
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DrawRcetangle dRcetangle = new DrawRcetangle();
		ObjectAdapter oAdapter = new ObjectAdapter(dRcetangle);
		System.out.println(oAdapter.DrawCircle());
		System.out.println(oAdapter.drawRcetangle.drawRcetangle());
	}

}
