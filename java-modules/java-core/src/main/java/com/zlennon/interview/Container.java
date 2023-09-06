/**
 * 
 */
package com.zlennon.interview;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * @author zlennon
 *
 */
public class Container<T> {
		List<T> list =new ArrayList<T>();
		Collection connection = new ArrayList<T>();
		public void add(T t){
			list.add(t);
		}
		
		public void delete(T t){
			list.remove(t);
		}
		
		public Object find(T t){
			if(list.contains(t)){
				return t;
			}
			return null;
			
		}
		
		public static void main(String[] args) {
			Container<Integer> C1 = new Container<Integer>();
			Container<Object> C2 = new Container<Object>();
		}
}
