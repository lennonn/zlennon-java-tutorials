package com.zl.service.spring;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zl.dto.domain.Dept;
import com.zl.persistence.hibernate.TransactionDAOTest;

public class TransactionServicewww {

	@Test
	public final void TestSpringTransaction() {
		@SuppressWarnings("resource")
		ApplicationContext ac = new ClassPathXmlApplicationContext("app*.xml");
		/*ApplicationContext ac = new FileSystemXmlApplicationContext(new String[]{
				"app-action.xml","app-service.xml","app-dao.xml","app-applicationContext.xml"
		});*/
		TransactionDAOTest rr =(TransactionDAOTest)ac.getBean("transactionDAO");
		System.out.println(
				ac.getDisplayName()+"\n"
				+ac.getEnvironment());
		Dept dept = (Dept)ac.getBean("dept");
		dept.setDeptno(40);
		dept.setDname("DDDDDDD");
		dept.setLoc("here");
		TransactionService ts = (TransactionService)ac.getBean("transactionService");
		ts.saveDept(dept);
	}

}
