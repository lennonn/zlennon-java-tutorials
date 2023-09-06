
package com.zlennon.mockito.soa;

import com.zlennon.mockito.soa.client.service.DNAFingerPrintService;
import com.zlennon.mockito.soa.client.service.DNAFingerPrintServiceServiceLocator;
import com.zlennon.mockito.soa.client.service.DNAFingerPrintWsInvoker;
import com.zlennon.mockito.soa.dto.DNAProfile;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.xml.rpc.ServiceException;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DNAFingerPrintWsInvokerTest {

	DNAFingerPrintWsInvoker invoker;
	@Mock
	DNAFingerPrintService mockService;
	@Mock
	DNAFingerPrintServiceServiceLocator mockLocator;
	
	@Before
	public void setup() throws ServiceException {
		invoker = new DNAFingerPrintWsInvoker(){
			protected DNAFingerPrintServiceServiceLocator getServiceLocator() {
				return mockLocator;
			}
		};

		when(mockLocator.getDNAFingerPrintService()).thenReturn(mockService);
	}
	
    @Test
	public void finds_DNA_match() throws Exception {
		when(mockService.findMatch(isA(DNAProfile.class))).thenReturn("Sherlock");
		assertEquals("Sherlock", invoker.findMatch(new DNAProfile()));
	}
}
