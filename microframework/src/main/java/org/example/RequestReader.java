package org.example;

/**
 * This class reads a string for return a correct response to show it
 */
public class RequestReader {

    private String response;
    private String path;
    public String restAPIMethod;

    public RequestReader(){
        response = "";
        restAPIMethod = "";
        path = "/";
    }

    /**
     * this method read the path specified if the Rest method is GET
     * if we can read it, we assign the response to the variable "response"
     * @param pathToRead
     */
    public void readPath(String pathToRead){
        if (pathToRead.split(" ").length>1) {
            restAPIMethod = pathToRead.split(" ")[0];
            path = pathToRead.split(" ")[1];
            if (restAPIMethod.equals("GET") && !path.equals("/favicon.ico")) {
                response = path;
            }
        }
    }

    /**
     * This method evaluate the path we wrote in the url for read and return if is an image, html or text
     * @param path
     * @return
     */
    public String[] evaluePath(String path){
        String[] responses = new String[2];
        responses[0] = "text";
        responses[1] = path;
        if (path.contains("pages")) {
            if (path.equals("/pages/")) {
                responses[0] = "image";
            }
            else if (path.contains("png")){
                responses[0] = "image";
                responses[1] = path.split("/")[2];
            } else{
                responses[0] = "html";
                responses[1] = path.split("/")[2];
            }
        }
        return responses;
    }

    public String getResponse() {
        return response;
    }

    public String getRestAPIMethod() {
        return restAPIMethod;
    }

    public String getPath() {
        return path;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}