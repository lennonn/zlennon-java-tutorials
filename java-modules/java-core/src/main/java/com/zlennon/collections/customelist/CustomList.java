/**
 * 
 */
package com.zlennon.collections.customelist;


import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zlennon
 * @param <T>
 *
 */
public class CustomList extends AbstractList implements List {
	private Object[] object;
		public CustomList(){
		object =  new Object[10];
		}
		public CustomList(int size){
			object =new Object[size];
		}
		private int size = 0;
        @Override
		public boolean add(Object obj){
        	if(size==object.length){
        		Object[] temp=new Object[size*2];
        		for(int i=0; i<object.length;i++){
        			temp[i]=object[i];
	}
        		temp[size]=obj;
        		object =temp;
        		size++;
        		return true;
        	}else{
        		object[size]=obj;
        		size++;
        		return false;
        	}
        }	
        public static void main(String[] args) {
        	CustomList list = new CustomList();
        	List list2 = new ArrayList<>();
        	list.remove(1);
			for (int i =1 ;i<20;i++){
				list.add(i);
			}
			System.out.println(list.size());
			System.out.println(list.get(5));
		}
		@Override
		public Object get(int i) {
			
			return object[i-1];
		}
		@Override
		public int size() {
			return size;
		}
		@Override
		public Object remove(int i) {
			return super.remove(i);
		}
		
}
