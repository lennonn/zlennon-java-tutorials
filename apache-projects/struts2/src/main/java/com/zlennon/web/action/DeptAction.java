package com.zlennon.web.action;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.zlennon.entity.Dept;
import com.zlennon.exception.ParamIncorrectException;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;


@ParentPackage("myAop")

@Results({
		@Result(name="error", location="/WEB-INF/jsp/common/errorPage.jsp"),
})
@ExceptionMappings({
		@ExceptionMapping(exception = "java.lang.Exception", result = "error")
})
@ResultPath("/WEB-INF/jsp")
@Namespace("/dept")
@InterceptorRefs({
		@InterceptorRef("myInterceptor"),
		@InterceptorRef("myStack")
})
public class DeptAction extends ActionSupport{

	Dept dept;
	HttpServletRequest httpServletRequest;

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	static HashMap<Integer,Dept> depts = new HashMap<>();


	@Action(value="submitDept",results={@Result(name="submit",location="saveDept.jsp")})
	public String submitDept(){
		try {
			int i = 3 / 1;
		}catch (Exception e){
			return "error";
		}
		return "submit";
	}
   /*
   exceptionMappings 属性是一个数组，用于配置处理器方法抛出的异常与结果之间的映射关系。
   在上述代码中，有一个 @ExceptionMapping 注解指定了当 ParamIncorrectException 异常被抛出时应该返回的结果是 businessError，
   并且排除请求参数中名为 dname 的参数，同时将 HTTP 状态码设置为 30009。这意味着当 ParamIncorrectException 异常被抛出时，
   请求将被重定向到 404.jsp 页面，响应状态码将是 30009，并且请求参数中的 dname 参数将被排除。
   results 属性也是一个数组，用于指定不同的结果名称和对应的视图或逻辑名。在上述代码中，
   有两个 @Result 注解，一个指定了当结果名称是 saved 时应该跳转到 deptList.jsp 页面，另一个指定了当结果名称是 businessError 时应该跳转到 404.jsp 页面。
   这意味着当处理器方法成功执行并返回 saved 结果时，请求将被重定向到 deptList.jsp 页面，而当处理器方法抛出 ParamIncorrectException 异常时，请求将被重定向到 404.jsp 页面。
    */
	@Action(value="saveDept",exceptionMappings = {
			@ExceptionMapping(exception = "com.zlennon.exception.ParamIncorrectException", result = "businessError",
					params = {"statusCode" ,"30009", "excludeParams", "${exception.message}"}) },
			results={@Result(name="saved",location="deptList.jsp"),
					@Result(name="businessError",location="/WEB-INF/jsp/common/404.jsp")
			})
	public String saveDept() throws ParamIncorrectException {
		if(dept.getDname().equals("")){
			throw new ParamIncorrectException("部门名称不能为空！");
		}
		if(dept.getDeptno()==0){
			throw new ParamIncorrectException("部门编号不能为空！");
		}
		depts.put(dept.getDeptno(),dept);
		queryDeptList();
		return "saved";
	}

	@Action(value="queryDeptSingle",results={@Result(name="queryDeptSingle",location="queryDept.jsp")})
	public String queryDeptSingle(){
		return "querySuccess";
	}
	@Action(value="queryDeptByNo",results={@Result(name="queryDeptByNo",location="queryDept.jsp")})
	public String queryDeptByNo(){
		httpServletRequest=ServletActionContext.getRequest();
		Dept dept = depts.get(this.dept.getDeptno());
		httpServletRequest.setAttribute("Dept", dept);
		return "querySuccess";
	}

	public void queryDeptList(){
		httpServletRequest=ServletActionContext.getRequest();
		List<Dept> list =new ArrayList<>();
		depts.forEach((integer, dept) -> {
			list.add(dept);
		});
		httpServletRequest.setAttribute("deptList", list);
	}
}
