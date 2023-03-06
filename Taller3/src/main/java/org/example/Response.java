package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Response {
    private static Response _instance = new Response();
    private String contentType;
    private String path;

    public Response(){}
    public static Response getInstance() {return _instance;}

    public String getResponse() {
        String result = "";
        Path file = Paths.get("src/main/resources/"+path);
        System.out.println(file);
        try (InputStream in = Files.newInputStream(file);
             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                result += line;
            }
        } catch (NoSuchFileException x) {
        } catch (IOException e) {
        }
        return result;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
