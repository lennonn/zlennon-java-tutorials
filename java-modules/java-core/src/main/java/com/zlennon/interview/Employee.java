package com.zlennon.interview;

public class Employee implements Comparable<Employee> {
	private  String name;
	private  Double salary;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Double getSalary() {
		return salary;
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Employee o) {
            int first =this.name.length();
            int temp =0;
            for(int i=0;i<first;i++){
                 if(Integer.valueOf(this.name.charAt(i))>Integer.valueOf(o.name.charAt(i))){
                	 temp++;
                	 break;	
                 }else if(Integer.valueOf(this.name.charAt(i))==Integer.valueOf(o.name.charAt(i))){
                	 continue;
                 }
                 else{
                	 return -1;
                 }
            }
                 if(temp==0){
                	 return -1;
                 }else{
                	 return 1;
                 }

	}
	public static void main(String[] args) {
		Object e[] =new Employee[10];
		Employee e1 =new Employee();
		e1.setName("dfgafetg");
		Employee e2 =new Employee();
		e2.setName("mmd");
		Employee e3 = new Manager();
		e3.setName("mma");
		/*if(e1.compareTo(e2)!=-1){
			System.out.println("e1>e2");
		}else{
			System.out.println("e1<e2");
		}*/
		if(e2.compareTo(e3)!=-1){
			System.out.println("e2>e3");
		}else{
			System.out.println("e2<e3");
		}
	}
    }
