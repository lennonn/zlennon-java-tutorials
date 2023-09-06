package com.zlennon.commonslogging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JCLExample {

    private static Log logger = LogFactory.getLog(JCLExample.class);

    public static void logRecord() throws IOException {
       // addLogToConsole();
        //addLogToFile();
        addLogBridgeToSlf4j();
    }

    public static void main(String[] args) throws IOException {
        logRecord();
    }


    public static void  addLogToConsole(){
        // 记录日志消息
        logger.info("info to console");
    }


    public static void addLogToFile() throws IOException {


    }


    public static void addLogBridgeToSlf4j() throws IOException {
        logger.debug("This is a DEBUG level log message.");
        logger.info("This is an INFO level log message.");
        logger.warn("This is a WARN level log message.");
        logger.error("This is an ERROR level log message.");
    }

}
