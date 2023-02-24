package org.example;

public class JUnitTest{

    @RequestMapping(value = "/")
    public static String index(){
        return "Greetings from Spring boot";
    }

    @RequestMapping(value = "")
    public static void m2(){}

}