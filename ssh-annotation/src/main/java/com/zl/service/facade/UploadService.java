package com.zl.service.facade;

import java.util.List;

import com.zl.dto.domain.Category;
import com.zl.dto.domain.FileSource;

public interface UploadService {
	public void saveFileInfo(FileSource f);
	public List<Category> getCategoryAll();
}
