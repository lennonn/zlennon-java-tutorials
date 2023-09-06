package com.zlennon.log4j.log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class Log4j12Example {

    public static void main(String[] args) {
        logRecord();
    }

    private static Logger logger = LoggerFactory.getLogger(Log4j12Example.class);

    public static void logRecord() {
        logger.debug("This is a DEBUG level log message.");
        logger.info("This is an INFO level log message.");
        logger.warn("This is a WARN level log message.");
        logger.error("This is an ERROR level log message.");
    }



}
