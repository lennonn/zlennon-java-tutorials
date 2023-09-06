
package com.zlennon.mockito.soa;

import com.zlennon.mockito.soa.client.service.DNAFingerPrintWsInvoker;
import com.zlennon.mockito.soa.dto.DNAProfile;
import org.junit.Before;
import org.junit.Test;

import javax.xml.rpc.ServiceException;

import static org.junit.Assert.assertEquals;


public class DNAFingerPrintWsInvokerIntegrationTest {

	DNAFingerPrintWsInvoker invoker;

	@Before
	public void setup() throws ServiceException {
		invoker = new DNAFingerPrintWsInvoker();
	}
	
    @Test
	public void finds_DNA_match() throws Exception {
		assertEquals("sujoy", invoker.findMatch(new DNAProfile()));
	}
}
