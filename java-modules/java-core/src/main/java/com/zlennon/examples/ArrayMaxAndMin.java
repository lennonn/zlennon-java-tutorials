/**
 *
 */
package com.zlennon.examples;

/**
 * @author zlennon
 * purpose: 求数组的最大值和最小值
 *
 */
public class ArrayMaxAndMin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int max,min;
		int a[] ={1,100,300,2,59 ,89};
		max=min=a[0];
		for(int i=0 ;i<a.length;i++){
			if(a[i]>max){
				max=a[i];
			}else if (a[i]<min) {
				min=a[i];
			}
		}
		System.out.println("MAX:"+max);
		System.out.println("MIN:"+min);
	}

}
