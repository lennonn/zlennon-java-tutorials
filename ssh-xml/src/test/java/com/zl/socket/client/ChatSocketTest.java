/**
 *
 */
package com.zl.socket.client;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author zlennon
 *
 */
public class ChatSocketTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("chat start =======================");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("chat end ==================");
	}

	/**
	 * Test method for {@link com.zl.socket.client.ChatSocketClient#chatSocketClient()}.
	 */
	@Test
	public final void testChatSocketClient() {
		ChatSocketClient chatSocketClient = new ChatSocketClient();
		//chatSocketClient.run();
	}

}
