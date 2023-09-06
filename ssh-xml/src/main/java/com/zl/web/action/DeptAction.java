package com.zl.web.action;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.opensymphony.xwork2.ActionSupport;
import com.zl.dto.domain.Dept;
import com.zl.service.spring.TransactionService;
import org.apache.struts2.ServletActionContext;

public class DeptAction extends ActionSupport {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	Dept dept;
	//TransactionService transactionService;
	HttpServletRequest httpServletRequest;
	public void setTransactionService(TransactionService transactionService) {
		//this.transactionService = transactionService;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}


	public String saveDept(){
		//transactionService.saveDept(dept);
		return "saved";
	}
	public String queryDept(){
		httpServletRequest= ServletActionContext.getRequest();
		//Dept dept2 = new Dept();
		//dept2.setDeptno(54);
		//Dept deptQuery=transactionService.queryDept(dept);
		//httpServletRequest.setAttribute("Dept",deptQuery );
		return "querySuccess";
	}
	public String queryDeptList(){
		httpServletRequest=ServletActionContext.getRequest();
		//List<Dept> list = transactionService.queryDeptList();
		//httpServletRequest.setAttribute("deptList", list);
		return "queryListSuccess";
	}
}
