/**
 *
 */
package com.zlennon.examples;


/**
 * @author zlennon
 *
 * summarise:浅拷贝是指在拷贝对象时，对于基本数据类型的变量会重新复制一份，而对于引用类型的变量只是对引用进行拷贝，
 *	没有对引用指向的对象进行拷贝。而深拷贝是指在拷贝对象时，同时会对引用指向的对象进行拷贝。
 *	区别就在于是否对  对象中的引用变量所指向的对象进行拷贝。
 */
public class ShallowAndDeepCopy {

	/**
	 * @param args
	 */
	/*@Override
	protected Object clone() throws CloneNotSupportedException {
		ShallowAndDeepCopy shallowAndDeepCopy;
		shallowAndDeepCopy=(ShallowAndDeepCopy) super.clone();
		return shallowAndDeepCopy;
	}*/
	class Student implements Cloneable{
		int stuNum;
		Address address;
		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public int getStuNum() {
			return stuNum;
		}

		public void setStuNum(int stuNum) {
			this.stuNum = stuNum;
		}
		@Override
		protected Object clone() {
			Student student =null;
			try {
				student =(Student) super.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return student;
		}

	}
	class Address implements Cloneable{
		String address;

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		@Override
		protected Object clone() {
			// TODO Auto-generated method stub
			Address address = null ;
			try {
				address = (Address) super.clone();
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return address;
		}
	}
	public static void main(String[] args) {
		ShallowAndDeepCopy.Student student1 =new ShallowAndDeepCopy().new Student();
		student1.setStuNum(88888);
		ShallowAndDeepCopy.Address address1 = new ShallowAndDeepCopy().new Address();
		address1.setAddress("北京市海淀区");
		student1.setAddress(address1);
		ShallowAndDeepCopy.Student  student2=(Student) student1.clone();
		student2.setStuNum(44444);
		//Address address2 = address1;
		Address address2= (Address) address1.clone();
		address2.setAddress("北京市昌平区");
		System.out.println("student1:"+student1.getStuNum()+"---地址:"+address1.getAddress());
		System.out.println("student2:"+student2.getStuNum()+"---地址:"+address2.getAddress());
		System.out.println(student1==student2);
		System.out.println(address1==address2);
	}

}
