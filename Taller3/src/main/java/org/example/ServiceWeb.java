package org.example;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ServiceWeb {
    public static String getHeader(String guia) {
        return "HTTP/1.1 200 OK\r\n" +
                "Content-type: text/"+guia+"\r\n" +
                "\r\n";
    }

    public static String getResponse(String guia) {
        String content = "";
        try {
            content = new String(Files.readAllBytes(Paths.get("src/main/resources/"+guia+"")), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return content;
    }
}