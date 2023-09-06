package com.zl.listener;

import java.io.IOException;
import java.net.ServerSocket;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServerSocketListener implements ServletContextListener {
	private ServerSocket serverSocket;
	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		if(serverSocket!=null){
			try {
				serverSocket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		if(serverSocket==null){
			try {
				serverSocket = new ServerSocket(8180);
			} catch (IOException e) {
				// TODO Auto-generated catch block
			 System.err.println(e.getMessage());
			}
		}
	}

}
