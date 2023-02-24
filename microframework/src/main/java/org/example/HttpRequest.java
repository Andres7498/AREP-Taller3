package org.example;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class HttpRequest {

    public static void main(String args[]) throws IOException {
        String read_url = "http://localhost:35000/something?h=10";
        URL url = new URL(read_url);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        Map<String, List<String>> headers = con.getHeaderFields();
        System.out.println(headers);

    }
}