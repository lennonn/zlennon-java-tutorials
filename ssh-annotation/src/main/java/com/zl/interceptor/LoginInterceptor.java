package com.zl.interceptor;

import jakarta.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import com.zl.dto.domain.User;

public class LoginInterceptor extends MethodFilterInterceptor {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected String doIntercept(ActionInvocation actionInvocation) throws Exception {

/*		HttpSession session =actionInvocation.getInvocationContext();

		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "prepareLogin";
		}*/
		return actionInvocation.invoke();
	}

}
