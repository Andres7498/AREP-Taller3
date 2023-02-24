package org.example;

import java.lang.reflect.InvocationTargetException;
import java.net.*;
import java.io.*;

public class HttpServer {

    private static RequestReader requestReader;
    /**
     * This method runs the server on port 35000 and showing an answer in the site
     * @throws IOException
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws ClassNotFoundException
     */
    public void start() throws IOException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        requestReader = new RequestReader();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(getPort());
        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        Socket clientSocket = null;
        boolean flag = true;
        while (flag) {
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
            String path = "";
            while ((inputLine = in.readLine()) != null) {
                requestReader.readPath(inputLine);
                if (!requestReader.getResponse().equals("")) {
                    getServiceOutput(out, requestReader.getResponse(), clientSocket.getOutputStream());
                }
                requestReader.setResponse("");

                if (!in.ready()) {
                    break;
                }
            }
            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
    }

    /**
     * This method shows the method's message from webService, depends on what he received like parameter
     *
     * @param out
     * @param path
     * @param outputStream
     * @return String HTML body
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     */
    private static void getServiceOutput(PrintWriter out, String path, OutputStream outputStream) throws InvocationTargetException, IllegalAccessException {
        String outputLine = "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n";
        String[] responses = requestReader.evaluePath(path);
        switch (responses[0]) {
            case "image":
                ReadFile.getImage(responses[1], outputStream);
                break;
            case "html":
                outputLine += ReadFile.readFiles(responses[1]);
                out.println(outputLine);
                break;
            case "text":
                outputLine += MicroJunit.invoke(path);
                out.println(outputLine);
                break;
        }
    }
    /**
     * This method gets the value of the specified environment variable, if is null returns 35000 by default
     * @return int PORT
     */
    public int getPort(){
        int port = 35000;
        if (System.getenv("PORT")!=null){
            port = Integer.parseInt(System.getenv("PORT"));
        }
        return port;
    }
}
