package com.zl.web.action;



import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.InterceptorRefs;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;
import com.zl.dto.domain.User;
import com.zl.service.facade.UserService;
import com.zl.util.security.EncryptorMgr;

import javax.servlet.http.HttpSession;

@ParentPackage("userlogin")
@InterceptorRefs({
		@InterceptorRef(value="loginInterceptor"),
	    @InterceptorRef("defaultStack")
})
public class UserAction extends ActionSupport {

	/**
	 *
	 */

	private static final long serialVersionUID = 1L;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private User user;
	private UserService userService;
	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	public UserAction() {
		// TODO Auto-generated constructor stub
	}
	@Action(value="regist",results={@Result(name="success",location="register.jsp")})
	public String excute(){
		return SUCCESS;
	}
	@Action(value="registerInfo",
			results={@Result(name="success",location="common/success.jsp"),
					 @Result(name="error" ,location="common/errorPage.jsp")
	})
	public String saveRegisterInfo(){
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = dateFormat.format(date);
		String password = EncryptorMgr.encrypt(user.getPassword());
		user.setPassword(password);
		user.setRegisterTime(Timestamp.valueOf(time));
		userService.saveRegisterInfo(user);

		return SUCCESS;
	}
	@Action(value="prepareLogin",
			results={@Result(name="prepareLogin",location="preLogin.jsp"),
					 @Result(name="login",location="download/index.jsp")
	})
	public String prepareLogin() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object user = session.getAttribute("user");
		if (user != null) {
			return "login";
		}
		return "prepareLogin";
	}
	@Action(value="login",
			results={@Result(name="prepareLogin",location="preLogin.jsp"),
					 @Result(name="login",location="download/index.jsp")
	})
	public String login() {
		HttpSession session = ServletActionContext.getRequest().getSession();
//		Object user = session.getAttribute("user");
//		if (user != null) {
//			return USER_HOME;
//		}

		String password = EncryptorMgr.encrypt(user.getPassword());
		user.setPassword(password);
		User u = userService.userLogin(user);
		if (u == null) {
			return prepareLogin();
		}
		session.setAttribute("user", u);
		return "login";
	}




	@Action(value="logout",
			results={@Result(name="prepareLogin",location="preLogin.jsp")
	})
	public String logout() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("user");
		return "prepareLogin";
	}
	/*
	public String adminLogin() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		Object admin = session.getAttribute("admin");
		if (admin != null) {
			List<User> users = userService.getUserList();
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("users", users);
			return ADMIN_HOME;
		}

		String relPasswd = username + "Root";
		if (relPasswd.equals(password)) {
			nickname = username;
			admin = constructUser();
			session.setAttribute("admin", admin);
			List<User> users = userService.getUserList();
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("users", users);
			return ADMIN_HOME;
		}
		return ADMIN_LOGIN;
	}

	public String adminLogout() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		session.removeAttribute("admin");
		return ADMIN_LOGIN;
	}

	public String resetPasswd() {
		if (password == null) {
			password = username;
		}
		password = EncryptorMgr.encrypt(password);
		userService.modifyPassword(id, password);
		return ADMIN_HOME;
	}

	public String deleteUser() {
		userService.deleteUser(id);
		return ADMIN_HOME;
	}
*/

	public static void main(String[] args) {
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = dateFormat.format(date);
		System.out.println(Timestamp.valueOf(time));
	}
}
