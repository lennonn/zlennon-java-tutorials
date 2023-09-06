package com.zlennon.mockito.soa.client.service;

import com.zlennon.mockito.soa.dto.DNAProfile;

import javax.xml.rpc.ServiceException;
import java.rmi.RemoteException;



public class DNAFingerPrintWsInvoker {

	public String findMatch(DNAProfile dnaProfile) throws RemoteException,
			ServiceException {
		return getServiceLocator().getDNAFingerPrintService().findMatch(dnaProfile);
	}

	protected DNAFingerPrintServiceServiceLocator getServiceLocator() {
		return new DNAFingerPrintServiceServiceLocator();
	}

}
