package com.zlennon.mockito.gwt.client.view;

import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.user.client.ui.HasValue;
import com.google.gwt.user.client.ui.Widget;

public interface QueryView {
	Widget asWidget();
	HasClickHandlers getQueryButton();
	HasValue<String> getRoomNumber();
}
