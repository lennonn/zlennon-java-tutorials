/**
 * 
 */
package com.zlennon.factory.simplefactory;

/**
 * @author zlennon
 *
 */
public  class FactoryBMW {
		public BWM createBMW(String name){
			if(name.equals("BWM520LI")){
				return new BWM520Li(name);
			}if(name.equals("BWM525LI")){
				return new BWM525Li(name);
			}else{
				return null;
			}
		};
		public static void main(String[] args) {
			FactoryBMW fb =new FactoryBMW();
			BWM  bwm525 =fb.createBMW("BWM525LI");
			BWM  bwm520 = fb.createBMW("BWM520LI");
			System.out.println(bwm520.getName());
			System.out.println(bwm525.getName());
		}
}
