package log4j;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Logger;

import java.io.*;
import java.sql.SQLException;

public class Log {

    /* Get actual class name to be printed on */
    public static Logger log = Logger.getLogger(Log.class.getName());
    public static void main(String[] args)throws IOException,SQLException{
        log.debug("Hello this is a debug message");
        log.info("Hello this is an info message");
    }
}