package com.zlennon.mockito.gwt.client.view;

import java.math.BigDecimal;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;
import com.zlennon.mockito.gwt.client.Bill;

public interface DetailsView {
	Widget asWidget();
	HasClickHandlers getPaymentButton();
	HasClickHandlers getCloseButton();
	HasValue<String> getPaymentAmount();
	BigDecimal getOutstandingAmount();
	void populate(Bill bill);
}
