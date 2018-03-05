package com.toful;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Log4net simple app");
        Logger log = LogManager.getLogger();
        log.debug("Debug log message");
        log.info("Info log message");
        log.warn("Warning log message");
        log.error("Error log message");
        log.fatal("Fatal error log message");
        
        new Scanner(System.in).nextLine();
    }
}
