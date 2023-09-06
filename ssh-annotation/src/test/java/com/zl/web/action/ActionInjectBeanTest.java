/**
 *
 */
package com.zl.web.action;

import org.apache.catalina.core.ApplicationContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zl.dto.domain.FileSource;
import com.zl.service.facade.UploadService;

/**
 * @author zlennon
 *
 */
public class ActionInjectBeanTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * Test method for {@link com.zl.web.action.UploadAction#uploadSingle()}.
	 */
	@Test
	public final void testUploadSingle() {
		ClassPathXmlApplicationContext applicationContext =new ClassPathXmlApplicationContext("applicationContext.xml");
		UploadService uploadService = (UploadService) applicationContext.getBean("uploadService");
		FileSource fileSource = (FileSource) applicationContext.getBean("fileSource");
		fileSource.setFileName("test");
		uploadService.saveFileInfo(fileSource);
		uploadService.saveFileInfo(new FileSource());
	}
}
