package com.zl.persistence.hibernate.dao;

import java.util.List;

import com.zl.dto.domain.Category;
import com.zl.dto.domain.FileSource;

public interface UploadDAO {
	public void saveFileInfo(FileSource f);
	public List<Category> getCategoryAll();
}
