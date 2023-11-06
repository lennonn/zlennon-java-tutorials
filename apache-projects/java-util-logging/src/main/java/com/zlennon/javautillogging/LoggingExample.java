package com.zlennon.javautillogging;

import org.slf4j.bridge.SLF4JBridgeHandler;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggingExample {
    public static void logRecord() throws IOException {
       // addLogToConsole();
        //addLogToFile();
        addLogBridgeToSlf4j();
    }

    public static void main(String[] args) throws IOException {
        logRecord();
    }


    public static void  addLogToConsole(){
        // 获取Logger对象
        Logger logger = Logger.getLogger(LoggingExample.class.getName());

        // 设置全局日志级别
        logger.setLevel(Level.INFO);

        // 创建控制台处理程序
        ConsoleHandler consoleHandler = new ConsoleHandler();

        // 设置控制台处理程序的级别
        consoleHandler.setLevel(Level.INFO);

        // 配置日志格式
        consoleHandler.setFormatter(new java.util.logging.SimpleFormatter());

        // 将处理程序添加到Logger
        logger.addHandler(consoleHandler);

        // 记录日志消息
        logger.info("info to console");
    }


    public static void addLogToFile() throws IOException {
        Logger logger = Logger.getLogger(LoggingExample.class.getName());

        FileHandler  fileHandler = new FileHandler("F:\\logs\\jul\\jul.log");

        // 将处理程序添加到Logger
        logger.addHandler(fileHandler);
        logger.info("logging to file jul.log");

    }


    public static void addLogBridgeToSlf4j() throws IOException {
        Logger logger = Logger.getLogger(LoggingExample.class.getName());

        // 将处理程序添加到Logger
        SLF4JBridgeHandler.install();

        logger.info("logging bridge to slf4j");

    }

}
