package com.zlennon.mockito.accelerating;

public class ErrorHandlerImpl implements ErrorHandler{

	@Override
	public void mapTo(Error errorMappingDto) {
		// TODO Auto-generated method stub
		errorMappingDto.setErrorCode(""+System.currentTimeMillis());
	}

}
