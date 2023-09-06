package com.zlennon.mockito.accelerating.voidmethods;

import com.zlennon.mockito.accelerating.DemoController;
import com.zlennon.mockito.accelerating.ErrorHandlerImpl;
import com.zlennon.mockito.accelerating.LoginController;
import com.zlennon.mockito.accelerating.MessageRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InjectMocksAnnotationTest {

	@Mock LoginController loginController;
	@Mock MessageRepository repository;
	@Spy ErrorHandlerImpl errorHandler;

	@InjectMocks
	DemoController controller;

	@Mock HttpServletRequest request;
	@Mock HttpServletResponse response;
	@Mock RequestDispatcher dispatcher;

	@Test
	public void when_mocks_are_injected() throws Exception {
		when(request.getServletPath()).thenReturn("/");
		when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);
		controller.doGet(request, response);

		verify(request).getRequestDispatcher(eq("login.jsp"));
	}
}
