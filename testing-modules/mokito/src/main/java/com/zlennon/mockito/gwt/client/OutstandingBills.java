package com.zlennon.mockito.gwt.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootPanel;
import com.zlennon.mockito.gwt.client.presenter.ApplicationController;
import com.zlennon.mockito.gwt.client.presenter.Presenter;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class OutstandingBills implements EntryPoint {

	private final BillingServiceAsync service = GWT.create(BillingService.class);

	/**
	 * This is the entry point method.
	 */
	@Override
	public void onModuleLoad() {
		Presenter presenter = new ApplicationController(service);
		presenter.render(RootPanel.get("dom"));
	}
}
