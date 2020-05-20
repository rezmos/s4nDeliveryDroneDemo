package co.com.domicilio.corrientazo.io;

import java.net.URL;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;

public class FileUtility {

    public static List<String> readFileInList(String fileName) {

        List<String> lines = Collections.emptyList();
        try {
            File file = getFileFromResources(fileName);
            lines = Files.readAllLines(Paths.get(file.getPath()), StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        return lines;
    }

    public static void writeFile(String fileName, String content) {

        try(FileWriter fw = new FileWriter(FileUtility.renameFile(fileName, "in"), true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(content);

        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    public static File getFileFromResources(String fileName) {

        ClassLoader classLoader = new FileUtility().getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    }

    public static String renameFile(String droneName, String fileType){
        String newDroneName = "";
        if (droneName.length()==1) {
            newDroneName = "0"+droneName;
        } else {
            newDroneName = droneName;
        }
        return fileType.concat(newDroneName)+".txt";
    }
}
