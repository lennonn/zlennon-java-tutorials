/**
 *
 */
package com.zl.web.action;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Actions;
import org.apache.struts2.convention.annotation.ExceptionMapping;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.ResultPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.opensymphony.xwork2.ActionSupport;
import com.zl.dto.domain.Category;
import com.zl.dto.domain.ChildCategory;
import com.zl.dto.domain.FileSource;
import com.zl.service.facade.UploadService;

/**
 * @author zlennon
 *
 */
@ParentPackage("struts-default")

@Action(value = "error", exceptionMappings = { @ExceptionMapping(exception = "java.lang.Exception", result = "common/errorPage.jsp", params = {
		"error", "value" }) })
public class UploadAction extends ActionSupport {

	/**
	 *
	 */
	private static final long serialVersionUID = 3536238274545006462L;
	// input
	private File upload; // 封装上传的文件 临时保存的
	private String uploadContentType; // 获得用户上传文件的类型
	private String uploadFileName; // 获得用户上传文件的名字
	private List<File> uploads = new ArrayList<File>(); // 使用集合来进行封装多个文件上传
	private List<String> uploadsContentType = new ArrayList<String>();
	private List<String> uploadsFileName = new ArrayList<String>();

	// output
	private String serverFileName; // 服务器保存的名字
	private long uploadFileSize;

	private List<String> serverFileNames = new ArrayList<String>();
	private List<Long> uploadsFileSizes = new ArrayList<Long>();

	// service

	UploadService uploadService;
	Category category;
	ChildCategory childCategory;

	@Autowired
	public void setChildCategory(ChildCategory childCategory) {
		this.childCategory = childCategory;
	}

	@Autowired
	public void setCategory(Category category) {
		this.category = category;
	}

	FileSource fileSource;

	@Autowired
	@Qualifier("fileSource")
	public void setFileSource(FileSource fileSource) {
		this.fileSource = fileSource;
	}

	@Autowired
	@Qualifier("uploadService")
	public void setUploadService(UploadService uploadService) {
		this.uploadService = uploadService;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadContentType() {
		return uploadContentType;
	}

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getServerFileName() {
		return serverFileName;
	}

	public void setServerFileName(String serverFileName) {
		this.serverFileName = serverFileName;
	}

	public long getUploadFileSize() {
		return uploadFileSize;
	}

	public void setUploadFileSize(long uploadFileSize) {
		this.uploadFileSize = uploadFileSize;
	}

	public List<File> getUploads() {
		return uploads;
	}

	public void setUploads(List<File> uploads) {
		this.uploads = uploads;
	}

	public List<String> getUploadsContentType() {
		return uploadsContentType;
	}

	public void setUploadsContentType(List<String> uploadsContentType) {
		this.uploadsContentType = uploadsContentType;
	}

	public List<String> getUploadsFileName() {
		return uploadsFileName;
	}

	public void setUploadsFileName(List<String> uploadsFileName) {
		this.uploadsFileName = uploadsFileName;
	}

	public List<String> getServerFileNames() {
		return serverFileNames;
	}

	public void setServerFileNames(List<String> serverFileNames) {
		this.serverFileNames = serverFileNames;
	}

	public List<Long> getUploadsFileSizes() {
		return uploadsFileSizes;
	}

	public void setUploadsFileSizes(List<Long> uploadsFileSizes) {
		this.uploadsFileSizes = uploadsFileSizes;
	}

	@Actions(value = { @Action(value = "uploadSingle", results = { @Result(name = "success", location = "common/success.jsp")
					,@Result(name = "error", location = "common/errorPage.jsp")}, interceptorRefs = {
			@InterceptorRef(value = "fileUpload", params = { "allowedTypes",
					"text/plain,image/x-png,image/bmp,image/jpeg",
					"maximumSize", "2097152" }),
			@InterceptorRef("defaultStack") },
			 exceptionMappings = { @ExceptionMapping(exception = "java.lang.Exception", result = "error", params = {
					"error", "value" }) }
							)
					}
			)
	public String uploadSingle() {
		// 从ServletContext().getReaPath("/upload")中获取系统部署的实际路径
		// /upload为自定义的文件夹，必须提前创建
		String serverPath = ServletActionContext.getServletContext()
				.getRealPath("/files/download");
		// 建立文件上传的完整路径，File.separator获取不同系统的'/'
		serverFileName = serverPath + File.separator + uploadFileName;
		try {
			copyFile(upload, serverFileName); // 把文件复制到实体硬盘
			uploadFileSize = upload.length();
			// 保存文件信息到数据库

			fileSource.setFileName(uploadFileName);
			fileSource.setFileUrl(serverPath);
			fileSource.setFileSize(uploadFileSize);
			fileSource.setUploadDate(new Date());
			fileSource.setUploadUser("test");

			if (uploadContentType.startsWith("image")) {
				category.setCName("picture");
				category.setCDesc("图片文件");
				category.setUpdateDate(new Date());

				childCategory.setCategory(category);
				childCategory.setCcName("子picture");
				childCategory.setCcDesc("子图片文件");
				childCategory.setUpdateDate(new Date());
			}else if(uploadContentType.startsWith("text")){
				category.setCName("text");
				category.setCDesc("文本文件");
				category.setUpdateDate(new Date());

				childCategory.setCategory(category);
				childCategory.setCcName("子text");
				childCategory.setCcDesc("子文本文件");
				childCategory.setUpdateDate(new Date());
			}
			//fileSource.setCategory(category);
			fileSource.setChildCategory(childCategory);
			uploadService.saveFileInfo(fileSource);
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return SUCCESS;
	}

	public UploadService getUploadService() {
		return uploadService;
	}

	public Category getCategory() {
		return category;
	}

	public FileSource getFileSource() {
		return fileSource;
	}

	public String uploadsUsingList() {
		String result = null;
		for (int i = 0; i < uploads.size(); i++) {
			upload = uploads.get(i);
			uploadFileName = uploadsFileName.get(i);
			result = uploadSingle();
			uploadsFileSizes.add(uploadFileSize);
			serverFileNames.add(serverFileName);
		}
		return result;
	}

	private void copyFile(File src, String dest) throws Exception {
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(
				src));
		DataOutputStream out = new DataOutputStream(new BufferedOutputStream(
				new FileOutputStream(dest)));
		int count; // 每次写入文件的大小
		byte[] b = new byte[512]; // 每次尽可能读取的大小
		while ((count = in.read(b)) != -1) {
			out.write(b, 0, count);
		}
		in.close();
		out.close();
	}
}
