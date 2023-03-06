package org.example;

import java.io.IOException;

public class SparkApp {

    public static void main(String[] args) throws IOException {
        Spark spark = Spark.getInstance();
        spark.get("/getTest", ((req, res) -> {
            res.setContentType("text/html");
            res.setPath("spark.html");
            return res.getResponse();
        }));
        HttpServer server = HttpServer.getInstance();
        server.run(args);
    }
}
