/**
 * 
 */
package com.zlennon.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author zlennon
 *
 */
public class IteratorTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("name5");
		list.add("name4");
		list.add("name3");
		list.add("name2");
		list.add("name1");
		//Iterator<String> it =list.iterator();
/*		for(Iterator<String> it =list.iterator();it.hasNext();){
			 String name =it.next();
			 System.out.println(name);
		}*/

		Iterator<String> iterator=list.iterator();
			while(iterator.hasNext()){
				String name =iterator.next();
				System.out.println(name);
			}

	}

}
