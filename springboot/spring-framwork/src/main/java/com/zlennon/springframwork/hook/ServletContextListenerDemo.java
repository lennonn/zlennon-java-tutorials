package com.zlennon.springframwork.hook;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ServletContextListenerDemo implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("Callback triggered - ServletContextListenerDemo.");
    }

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("ServletContextListenerDemo contextInitialized.");
    }
}