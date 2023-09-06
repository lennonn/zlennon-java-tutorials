/*
package com.zlennon.service;



import com.zlennon.dao.TransactionDao;
import com.zlennon.entity.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


//@Component
public class TransactionService {

	@Autowired
	private TransactionDao transactionDAO;
	public TransactionDao getTransactionDAO() {
		return transactionDAO;
	}
	public void setTransactionDAO(TransactionDao transactionDAO) {
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
*/
