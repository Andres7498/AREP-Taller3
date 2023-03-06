package org.example;

import java.net.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class HttpServer {

    private static HttpServer _instance = new HttpServer();
    private static final Map<String, String> cache = new HashMap<>();

    public HttpServer(){}
    public static HttpServer getInstance() {
        return _instance;
    }

    public void run(String[] args) throws IOException {
        Spark spark = Spark.getInstance();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }

        boolean running = true;
        while (running) {
            Socket clientSocket = null;
            try {
                System.out.println("Listo para recibir ...");
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            String inputLine, outputLine;

            boolean status = true;
            String method = "";
            String query = "";
            while ((inputLine = in.readLine()) != null) {
                if (status) {
                    method = inputLine.split(" ")[0];
                    query = inputLine.split(" ")[1];
                    status = false;
                }
                System.out.println("Received: " + inputLine);
                if (!in.ready()) {
                    break;
                }
            }

            if (query.startsWith("/apps/")) {
                outputLine = executeService(query.substring(5));
            } else if (query.startsWith("/spark/")) {
                if (method.equals("GET")) {
                    String path = query.substring(7);
                    String response = spark.getGetService(path);
                }
                outputLine = spark.getGetService(query.substring(7));
            } else {
                outputLine = htmlGetForm();
            }

            out.println(outputLine);
            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }



    private String executeService(String serviceName) {
        String header = ServiceWeb.getHeader(serviceName);
        String body = ServiceWeb.getResponse(serviceName);
        return header + body;
    }

    public static String htmlGetForm() {
        return "HTTP/1.1 200 OK\r\n" +
                "Content-type: text/html\r\n" +
                "\r\n" +
                "<!DOCTYPE html>\n" +
                "<html>\n" +
                "    <head>\n" +
                "        <title>Movie Form</title>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <h1>GET the movie you are looking for</h1>\n" +
                "        <form action=\"/movie\">\n" +
                "            <label for=\"name\">Name:</label><br>\n" +
                "            <input type=\"text\" id=\"name\" name=\"name\" value=\"John\"><br><br>\n" +
                "            <input type=\"button\" value=\"Submit\" onclick=\"loadGetMsg()\">\n" +
                "        </form> \n" +
                "        <div id=\"getrespmsg\"></div>\n" +
                "\n" +
                "        <script>\n" +
                "            function loadGetMsg() {\n" +
                "                let nameVar = document.getElementById(\"name\").value;\n" +
                "                const xhttp = new XMLHttpRequest();\n" +
                "                xhttp.onload = function() {\n" +
                "                    document.getElementById(\"getrespmsg\").innerHTML =\n" +
                "                    this.responseText;\n" +
                "                }\n" +
                "                xhttp.open(\"GET\", \"/movie?name=\"+nameVar);\n" +
                "                xhttp.send();\n" +
                "            }\n" +
                "        </script>\n" +
                "\n" +
                "    </body>\n" +
                "</html>";
    }

    public static Map<String, String> getCache() {
        return cache;
    }
}