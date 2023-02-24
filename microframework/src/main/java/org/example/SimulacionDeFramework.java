package org.example;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class SimulacionDeFramework {
    /**
     * The main, by default we pass the path of the webServices class
     * @param args
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, IllegalAccessException {
        args = new String[1];
        args[0]="co.edu.escuelaing.microspringboot.WebServices";
        MicroJunit microJunit = new MicroJunit();
        microJunit.start(args);
        HttpServer httpServer = new HttpServer();
        httpServer.start();
    }

}