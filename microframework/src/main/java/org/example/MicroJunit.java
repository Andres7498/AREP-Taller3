package org.example;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;


public class MicroJunit {

    private static HashMap<String, Method> requests = new HashMap<>();

    /**
     * This method adds to a hashmap all the methods with annotation RequestMapping
     * @param args
     * @throws ClassNotFoundException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws IOException
     */
    public static void start(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, IOException {
        String className = args[0];
        Class c = Class.forName(className);
        Method[] declareMethods = c.getMethods();
        int passed=0,failed = 0;
        for (Method m : declareMethods){
            if (m.isAnnotationPresent(RequestMapping.class)){
                requests.put(m.getAnnotation(RequestMapping.class).value(),m);
                passed+=1;
            }
        }
    }

    /**
     * This method returns the Method from a path specific
     * @param path
     * @return String The Method converted to String
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    public static String invoke(String path) throws InvocationTargetException, IllegalAccessException {
        return requests.get(path).invoke(null).toString();
    }
}