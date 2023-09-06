package com.zlennon;

import com.zlennon.resilience4j.Resilience4jService;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalTime;

@SpringBootTest
class SpringCloudResilience4JApplicationTests {

	@Autowired
	private Resilience4jService service;

	@Test
	void testProcess() throws InterruptedException {
		for (int i = 1; i <= 20; i++) {
			System.out.println(LocalTime.now() + " Starting service call = " + i);
			new Thread(service::bulkhead, "service-call-" + (i)).start();
			Thread.sleep(10);
		}
		Thread.sleep(10000);
	}

}
