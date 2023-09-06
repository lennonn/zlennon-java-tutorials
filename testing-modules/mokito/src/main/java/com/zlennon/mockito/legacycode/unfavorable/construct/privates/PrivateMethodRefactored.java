package com.zlennon.mockito.legacycode.unfavorable.construct.privates;


import com.zlennon.mockito.legacycode.unfavorable.construct.constructor.GraphicalInterface;

public class PrivateMethodRefactored {
	public Object validate(Object arg) {
		if(arg == null) {
			showError("Null input");
		}
		
		return arg;
	}

	protected void showError(String msg) {
		GraphicalInterface.showMessage(msg);
	}
}
