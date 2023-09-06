package com.zl.service.spring;

import java.util.List;

import jakarta.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zl.dto.domain.Category;
import com.zl.dto.domain.FileSource;
import com.zl.persistence.hibernate.dao.UploadDAO;
import com.zl.service.facade.UploadService;
@Service("uploadService")
@Transactional(propagation=Propagation.SUPPORTS)
public class UploadServiceSpringImpl implements UploadService {
	@Resource
	UploadDAO uploadDAO;
	public void setUploadDAO(UploadDAO uploadDAO) {
		this.uploadDAO = uploadDAO;
	}

	public UploadServiceSpringImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void saveFileInfo(FileSource f) {
		uploadDAO.saveFileInfo(f);
	}

	@Override
	public List<Category> getCategoryAll() {
		List<Category> categoryList=uploadDAO.getCategoryAll();
		return categoryList;
	}

}
