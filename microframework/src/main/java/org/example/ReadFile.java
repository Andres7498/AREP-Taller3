package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadFile {

    /**
     * This method reads a file to show it given the path specified
     * @param path
     * @return
     */
    public static String readFiles(String path){
        // Convert the string to a byte array.
        String result = "";
        Path file = Paths.get("src/main/resources/files/"+path);
        System.out.println(file);
        try (InputStream in = Files.newInputStream(file);
             BufferedReader reader =
                     new BufferedReader(new InputStreamReader(in))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                result += line;
            }
        } catch (NoSuchFileException x) {
            result = readFiles("page_not_found.html");
        } catch (IOException e) {
        }
        return result;
    }

    /**
     * This method can read and shows an image from the folder resources given the path specified
     * @param requestURI URI
     * @param outputStream OUT
     */
    public static void getImage(String requestURI, OutputStream outputStream) {
        if (requestURI.equals("/pages/"))requestURI="not_found.png";
        File file = new File("src/main/resources/files/images/" + requestURI);
        try {
            BufferedImage pic = null;
            pic = ImageIO.read(file);
            ByteArrayOutputStream picShow = new ByteArrayOutputStream();
            DataOutputStream picDraw = new DataOutputStream(outputStream);
            if(new File("src/main/resources/files/images/" + requestURI).isFile()) {
                ImageIO.write (pic, "PNG", picShow);
                picDraw.writeBytes("HTTP/1.1 200 OK\r\n" + "Content-Type: image/png \r\n\r\n");
                picDraw.write(picShow.toByteArray());
            }else{
                System.out.println("picccccccccccccccccccc");
                getImage("/pages/",outputStream);
            }

        } catch (IOException e) {

        }
    }
}
