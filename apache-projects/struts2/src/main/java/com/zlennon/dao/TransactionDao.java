/*
package com.zlennon.dao;


import com.zlennon.entity.Dept;
import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;
import java.util.List;


//@Repository
public class TransactionDao {

	@Autowired
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	//JdbcTemplate jdbcTemplate;
*/
/*	//HibernateTemplate hibernateTemplate;
public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}*//*

	//	public JdbcTemplate getJdbcTemplate() {
//		return jdbcTemplate;
//	}
//	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
//		this.jdbcTemplate = jdbcTemplate;
//	}

	public void  saveDept(Dept dept){
		sessionFactory.getCurrentSession().save(dept);
	}

	public void deleteDept(Dept dept){
		sessionFactory.getCurrentSession().delete(dept);
	}

	public Dept queryDept(Dept dept){
		Session session = sessionFactory.getCurrentSession();
		//Dept dept2 = (Dept) session.load(Dept.class, dept.getDeptno());
		Dept dept3 = (Dept) session.get(Dept.class, dept.getDeptno());
		return dept3;
	}

	public List<Dept> queryDeptList(){
		Session session = sessionFactory.getCurrentSession();

		String hql = "select dept from Dept dept";
		Query query = session.createQuery(hql);
		//List<Dept> list = (List<Dept>)query.setCacheable(true).list();
		List<Dept> list = (List<Dept>)query.setCacheMode(CacheMode.GET).list();
		System.out.println("***********测试是否通过查询缓存了数据*********");
		Dept dept =(Dept)session.get(Dept.class, 10);
		System.out.println(dept.getDname());
		System.out.println("***********如果没有sql语句说明已缓存，测试结束*********");

		return list;
	}
	public void  callProcedureTest(){
		Connection conn=null;
		CallableStatement proc = null;
		StringBuilder procStr = new StringBuilder("{ call ");
		procStr.append("GPFUNDAPPLY.AUTODEALSTATEBYCHECKNO").append("(?,?,?) }");
		try {
			//conn = hibernateTemplate.getSessionFactory().getCurrentSession();
			proc = conn.prepareCall(procStr.toString()); // 调用存储过程
			proc.registerOutParameter(2, Types.VARCHAR);
			proc.registerOutParameter(3, Types.VARCHAR);
			//proc.setDate(1,   new Date(8));
			proc.setString(1, "655");
			proc.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(proc != null){
				try{
					proc.close();
				}catch(Exception e){
					//logger.error("GfVouDtlDaoHibernateImpl.deleteVoudtl Close proc error:" + e);
				}
				proc = null;
			}
			if(conn != null){
				try{
					conn.close();
				}catch(Exception e){
					//logger.error("GfVouDtlDaoHibernateImpl.deleteVoudtl Close conn error:" + e);
				}
				conn = null;
			}
		}

	}
}
*/
