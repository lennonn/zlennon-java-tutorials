package com.zl.service.spring;



import java.util.List;

import com.zl.dto.domain.Dept;
import com.zl.persistence.hibernate.TransactionDAOTest;

public class TransactionService {
	private TransactionDAOTest transactionDAO;
	public TransactionDAOTest getTransactionDAO() {
		return transactionDAO;
	}
	public void setTransactionDAO(TransactionDAOTest transactionDAO) {
		this.transactionDAO = transactionDAO;
	}
	public void testSpringTransaction(){
		transactionDAO.callProcedureTest();
	}
	public void saveDept(Dept dept){
		transactionDAO.saveDept(dept);
		//transactionDAO.deleteDept(dept);
	}
	public Dept queryDept(Dept dept){
		Dept dept2=transactionDAO.queryDept(dept);
		return dept2;
	}
	public List<Dept> queryDeptList(){
		List<Dept> list =transactionDAO.queryDeptList();
		return list;
	}
}
