package com.zl.listener;

import com.zl.dto.domain.User;

import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class LoginListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		  System.out.println("当session建立时触发");
		  HttpSession session=arg0.getSession();

		  User user=(User) session.getAttribute("user");
		  if(user==null){
			  System.out.println("当前没有用户登录"+"============create");
		  }else{
			  System.out.println("用户:"+user.getName()+"已登录"+"============create");
		  }
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("当session销毁时触发");
		 HttpSession session=arg0.getSession();
		 if(session==null){
			 System.out.println("当前没有用户登录"+"============destory");
		 }else{
			 User user=(User) session.getAttribute("user");
			 if(user==null){
				 System.out.println("当前没有用户登录"+"============destory");
			 }else{
				 System.out.println("当前还在登陆的用户:"+user.getName()+"============destory");
			 }


		 }
	}

}
