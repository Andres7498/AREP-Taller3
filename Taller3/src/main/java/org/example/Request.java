package org.example;

public class Request {
    private static Request _instance = new Request();

    public Request(){}

    public static Request getInstance() {return _instance;}
}
