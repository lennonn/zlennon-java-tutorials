package com.zlennon.log4j.log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Slf4jLogbackExample {

    public static void main(String[] args) {
        logRecord();
    }

    private static Logger logger = LoggerFactory.getLogger(Slf4jLogbackExample.class);

    public static void logRecord() {
        logger.debug("This is a DEBUG level log message use logbckImpl.");
        logger.info("This is an INFO level log message  use logbckImpl.");
        logger.warn("This is a WARN level log message  use logbckImpl.");
        logger.error("This is an ERROR level log message  use logbckImpl.");
    }



}
