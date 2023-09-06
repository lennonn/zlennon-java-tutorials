package com.zl.service.spring;


import com.zl.service.facade.WebServiceTest;
import jakarta.jws.WebService;

@WebService
public class WebServiceTestSpringImpl implements WebServiceTest {

	@Override
	public String cxfTest(String message) {
		// TODO Auto-generated method stub
		return "Send CXF message";
	}

}
