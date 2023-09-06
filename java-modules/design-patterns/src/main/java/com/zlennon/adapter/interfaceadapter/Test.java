/**
 * 
 */
package com.zlennon.adapter.interfaceadapter;

/**
 * @author zlennon
 *
 */
public class Test {
	public static void main(String[] args) throws Exception {
		MyAdapter myAdapter = new MyAdapter();
		System.out.println(myAdapter.drawCircle());
		try {
			Class.forName("");
		} catch (Exception e) {
			System.err.println("dddd");
			throw e;
		}
	}
}
