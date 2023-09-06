package com.zl.web.action;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;

import com.opensymphony.xwork2.ActionSupport;

@ResultPath(value="/WEB-INF/jsp")
@Namespace("/")
public class IndexAction extends ActionSupport {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public IndexAction() {
		// TODO Auto-generated constructor stub
	}

	@Override

	@Action(value="uploadFile",results={@Result(name="success",location="/WEB-INF/jsp/upload/upload.jsp")}
				)

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

}
