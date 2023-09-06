package com.zlennon.javautillogging;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Level;
import java.util.logging.Logger;

@SpringBootApplication
public class JavaUtilLoggingApplication implements CommandLineRunner {

    private static final Logger LOGGER = Logger.getLogger(JavaUtilLoggingApplication.class.getName());

    public static void main(String[] args) {
        SpringApplication.run(JavaUtilLoggingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("JavaUtilLoggingApplication info");
        LoggingExample.logRecord();
    }
}
