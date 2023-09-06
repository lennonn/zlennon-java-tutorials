package com.zl.web.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.zl.dto.domain.User;
import com.zl.service.facade.UserService;

public class LoginAction extends ActionSupport {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private User u;


	private UserService userService;
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public LoginAction() {
		// TODO Auto-generated constructor stub
	}

	public String regist(){
		userService.saveRegisterInfo(u);
		return SUCCESS;
	}
}
