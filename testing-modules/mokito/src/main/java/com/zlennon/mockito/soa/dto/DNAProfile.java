package com.zlennon.mockito.soa.dto;

import java.util.List;

public class DNAProfile {
	private ProfileElement[] dnaElements;

	public ProfileElement[] getDnaElements() {
		return dnaElements;
	}

	public void setDnaElements(ProfileElement... dnaElements) {
		this.dnaElements = dnaElements;
	}
}
