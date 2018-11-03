package com.example.dorm_management.config;

import org.apache.log4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * Created by vuong on 11/3/2018.
 */
public class Basej4Logger {
    static Logger logger = Logger.getLogger("QUERY_LOOGER");
    static Basej4Logger instance = null;
    String separator = " | ";
    public static Basej4Logger getInstance(){
        if(instance == null){
            instance = new Basej4Logger();
        }
        return instance;
    }

    public void fatal(Object... objs) {
        logger.fatal(concat(objs));
    }

    public void fatal(Throwable t) {
        logger.fatal(getStackTrace(t));
    }

    public void error(Object... objs) {
        logger.error(concat(objs));
    }

    public void error(Throwable t) {
        logger.error(getStackTrace(t));
    }


    public void warn(Object... objs) {
        logger.warn(concat(objs));
    }

    public void warn(Throwable t) {
        logger.warn(getStackTrace(t));
    }

    public void info(Object... objs) {
        logger.info(concat(objs));
    }

    public void info(Throwable t) {
        logger.info(getStackTrace(t));
    }

    public void debug(Object... objs) {
        logger.debug(concat(objs));
    }

    public void debug(Throwable t) {
        logger.debug(getStackTrace(t));
    }

    public void trace(Object... objs) {
        logger.trace(concat(objs));
    }


    public void trace(Throwable t) {
        logger.trace(getStackTrace(t));
    }

    private String getStackTrace(Throwable t) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw, true);
        t.printStackTrace(pw);
        pw.flush();
        sw.flush();
        return sw.toString();
    }

    public Logger getLogger() {
        return logger;
    }

    public String concat(Object... objs) {
        StringBuilder builder = new StringBuilder();
        if (objs.length <= 0) return builder.toString();
        builder.append(objs[0]);
        for (int i = 1; i < objs.length; i++) {
            if(objs[i] instanceof Throwable){
                builder.append(separator).append(getStackTrace((Throwable) objs[i]));
            }
            else {
                builder.append(separator).append(objs[i]);
            }
        }
        return builder.toString();
    }
}
