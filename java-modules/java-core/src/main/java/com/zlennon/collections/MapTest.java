package com.zlennon.collections;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
	public static void main(String[] args) {
		Map<Integer,String> map =new HashMap<Integer,String>();
		map.put(1, "11111");
		map.put(2, "22222");
		map.put(3, "33333");
		map.put(4, "44444");
		
		for(int key:map.keySet()){
			System.out.println("key:"+key+"\n"+"value:"+map.get(key));
		}
		
		for(Map.Entry<Integer, String> entry:map.entrySet()){
			System.out.println("key:"+entry.getKey()+"==="+"value:"+entry.getValue());
		}
	}
}
