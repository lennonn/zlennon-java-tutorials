package com.zl.webservice.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zl.service.facade.WebServiceTest;



public class CXFWebServiceClient {
    public static void main(String args[]){
	ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:app-cxf-webservice.xml");
	WebServiceTest wst =(WebServiceTest)ac.getBean("webServiceCient");
	String s = wst.cxfTest("Client Recevie");
	System.out.println(s);
    }
}

