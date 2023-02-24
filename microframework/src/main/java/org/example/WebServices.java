package org.example;

public class WebServices {

    @RequestMapping(value = "/hello")
    public static String helloWorld(){
        return "hello world";
    }

    @RequestMapping(value = "/status")
    public static String serverStatus(){
        return "Running";
    }

    @RequestMapping("/")
    public static String index() {
        return "Greetings from FrameworkSimulator!";
    }

    @RequestMapping("index")
    public static String html() {return "";}


}