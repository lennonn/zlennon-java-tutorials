/**
 *
 */
package com.zl.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.zl.dto.domain.Category;
import com.zl.dto.domain.FileSource;
import com.zl.service.facade.UploadService;
import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author zlennon
 *
 */
@ParentPackage("struts-default")

public class DownloadAction extends ActionSupport {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	public DownloadAction() {
		// TODO Auto-generated constructor stub
	}

	public String inputPath;
	public String filename;
	private UploadService uploadService;
	HttpServletRequest httpServletRequest;
	@Autowired
	public void setUploadService(UploadService uploadService) {
		this.uploadService = uploadService;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getInputPath() {
		return inputPath;
	}

	public void setInputPath(String inputPath) {
		this.inputPath = inputPath;
	}
	@Action( value="index",
			 results={@Result(name = "success", location = "download/index.jsp"),
					  @Result(name = "error", location = "common/errorPage.jsp")
	})

	public String getDownloadFile() throws Exception {
		httpServletRequest =ServletActionContext.getRequest();
		List<Category> categoryList =uploadService.getCategoryAll();
		List<Category> category = new ArrayList<Category>();
		//Set<ChildCategory> childCategory = new HashSet<ChildCategory>();
		Set<FileSource> fileNameList =new HashSet<FileSource>();
		List<FileSource> fileAll = new ArrayList<FileSource>();
		for(Category c:categoryList){
			category.add(c);
			//childCategory= c.getChildCategories();
			fileAll.addAll(fileNameList);
		}
		//httpServletRequest.setAttribute("files", fileAll);
		httpServletRequest.setAttribute("categories", category);
		return SUCCESS;

	}


	/*public String getDownloadFile(){
		httpServletRequest =ServletActionContext.getRequest();
		List<Category> categoryList =uploadService.getCategoryAll();
		List<Category> category = new ArrayList<Category>();
		Set<FileSource> fileNameList =new HashSet<FileSource>();
		List<FileSource> fileAll = new ArrayList<FileSource>();
		for(Category c:categoryList){
			category.add(c);
			fileNameList= c.getFiles();
			fileAll.addAll(fileNameList);
		}
		httpServletRequest.setAttribute("files", fileAll);
		httpServletRequest.setAttribute("categories", category);
		return SUCCESS;
	}*/
	/*inputName - String - inputStream - һ�����������Ե����֣������Է��ص�InputStream���󽫱����͵������ ��
	bufferSize - int - 1024 - ͨ��InputStream�����ȡ���ݣ�ͨ��OutputStream�������������������ʱʹ�õĻ������ĳ��ȡ�
	contentType - String - text/plain - ��������HTTP��Ӧ���Content-Type��ͷ��
	contentLength - int - û�� -  ��������HTTP��Ӧ���Content-Length��ͷ��
	contentDisposition - String - inline - ��������HTTP��Ӧ���Content-Disposition��ͷ ��           */

	public InputStream getInputStream() throws IOException {
		String path = ServletActionContext.getServletContext().getRealPath("/");
		String filepath = path + "/" + filename;
		File file = new File(filepath);
		return FileUtils.openInputStream(file);
		// return ServletActionContext.getServletContext().getResourceAsStream(inputPath);
	}
	@Action( value="downloadSingle",params={"inputPath","/images/strutsdownload/error.jpg"},results={
			@Result(name = "success", type="stream",location = "common/success.jsp",params={"contentType","application/octet-stream;charset=ISO8859-1",
					"inputName","inputStream","contentDisposition","attachment;filename=\"${downloadFileName}\"","bufferSize","8192"}),
			@Result(name = "error", location = "common/errorPage.jsp")

	})
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	public String getDownloadFileName() throws UnsupportedEncodingException {
		String downloadFileName;
		String temp[] =filename.split("/");
		for(int i=0;i<temp.length;i++){
			System.out.println(temp[i]);
		}
		downloadFileName = URLEncoder.encode(temp[temp.length-1], "UTF-8");
		return downloadFileName;
	}

}
