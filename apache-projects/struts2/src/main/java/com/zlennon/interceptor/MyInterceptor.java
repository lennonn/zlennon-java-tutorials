package com.zlennon.interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import java.util.Locale;


public class MyInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        // interceptor code here
        System.out.println("MyInterceptor");
       // Locale locale = new Locale(ENGLISH);
        ActionContext.getContext().withLocale(Locale.US);
        ServletActionContext.getRequest().setAttribute("interceptor","MyInterceptor");
        return invocation.invoke();
    }
}
