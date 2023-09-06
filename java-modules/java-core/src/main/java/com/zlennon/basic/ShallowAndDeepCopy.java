/**
 *
 */
package com.zlennon.basic;

/**
 * @author zlennon
 *
 * summarise:??????????????????????????????????????????????????????????????????????????????????
 *	????????????????????????????????????????????????????????????????????
 *	????????????  ???????????????????????????????
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
		Student student1 =new ShallowAndDeepCopy().new Student();
		student1.setStuNum(88888);
		Address address1 = new ShallowAndDeepCopy().new Address();
		address1.setAddress("???????????");
		student1.setAddress(address1);
		Student  student2=(Student) student1.clone();
		student2.setStuNum(44444);
		//Address address2 = address1;
		Address address2= (Address) address1.clone();
		address2.setAddress("??????????");
		System.out.println("student1:"+student1.getStuNum()+"---???:"+address1.getAddress());
		System.out.println("student2:"+student2.getStuNum()+"---???:"+address2.getAddress());
		System.out.println(student1==student2);
		System.out.println(address1==address2);
	}

}
