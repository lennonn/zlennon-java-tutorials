package com.zlennon.springintegration;

import com.zlennon.springintegration.basic.helloworld.ChannelConfig;
import com.zlennon.springintegration.basic.helloworld.HelloService;
import com.zlennon.springintegration.dsl.kafka.KafkaAppProperties;
import com.zlennon.springintegration.dsl.kafka.KafkaDslService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableConfigurationProperties(KafkaAppProperties.class)
public class SpringIntegrationApplication implements CommandLineRunner {

	@Autowired
	static
	KafkaDslService kafkaDslService;
	@Autowired
	HelloService helloService;

	@Autowired
	ChannelConfig.LoggerGateway  loggerGateway;

	public static void main(final String[] args) {
		SpringApplication.run(SpringIntegrationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		helloService.sendAndReceiveTest();
		loggerGateway.sendToLogger("sendToLogger==>>>"+"zlennon");
	}
}
