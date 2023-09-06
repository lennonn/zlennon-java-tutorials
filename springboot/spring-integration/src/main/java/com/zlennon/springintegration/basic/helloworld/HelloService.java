/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zlennon.springintegration.basic.helloworld;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.PollableChannel;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;

/**
 * Simple POJO to be referenced from a Service Activator.
 *
 * @author Mark Fisher
 */
@Service
@Slf4j
public class HelloService {

	@Autowired
	MessageChannel inputChannel;
	@Autowired
	PollableChannel outputChannel;


	public String sayHello(String name) {
		//log.info("sayHello name:{}",name);
		return "Hello " + name;
	}


	public void sendAndReceiveTest(){
		inputChannel.send(new GenericMessage<>("World"));
		//log.info("==> HelloWorldDemo: " + outputChannel.receive(0).getPayload());
	}


}
