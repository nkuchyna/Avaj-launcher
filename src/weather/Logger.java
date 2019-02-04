package weather;

import java.io.*;

public class Logger
{
    public Logger(){}
    private static PrintWriter logger;
    public static void createLogger() throws FileNotFoundException, UnsupportedEncodingException {
        logger = new PrintWriter("simulation.txt", "UTF-8");
    }
    static public PrintWriter getLogger(){ return (logger);}
}