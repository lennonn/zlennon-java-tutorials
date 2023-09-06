package com.zlennon.mockito.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

import java.math.BigDecimal;


@RemoteServiceRelativePath("bill")
public interface BillingService extends RemoteService {

	public Bill retrieve(String rommNumber);
	public boolean pay(String roomNumber, BigDecimal amount);
	
}
