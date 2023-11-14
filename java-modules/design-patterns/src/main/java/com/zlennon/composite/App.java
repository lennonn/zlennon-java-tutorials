package com.zlennon.composite;

public class App {
    public static void main(String[] args) {
        Company parentCompany = new Company("科技公司");

        SubsidiaryCompany subsidiary1 = new SubsidiaryCompany("北京分公司");
        Department hrDepartment = new Department("北京Hr部门");
        Department devDepartment = new Department("北京研发部门");
        subsidiary1.add(hrDepartment);
        subsidiary1.add(devDepartment);

        SubsidiaryCompany subsidiary2 = new SubsidiaryCompany("广州分公司");
        Department finaceDepartment = new Department("广州财务部门");
        Department saleDepartment = new Department("广州销售部门");
        subsidiary2.add(finaceDepartment);
        subsidiary2.add(saleDepartment);

        parentCompany.add(subsidiary1);
        parentCompany.add(subsidiary2);

        parentCompany.showName();
    }
}
