package co.com.domicilio.corrientazo.io;

import java.net.URL;
import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;

public class FileReader {

    public static List<String> readFileInList(String fileName)
    {

        List<String> lines = Collections.emptyList();
        try
        {
            File file = getFileFromResources(fileName);
            lines = Files.readAllLines(Paths.get(file.getPath()), StandardCharsets.UTF_8);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }


        return lines;
    }

    /**
     *  Get file from classpath, resources folder
     */
    // get file from classpath, resources folder
    public static File getFileFromResources(String fileName) {

        ClassLoader classLoader = new FileReader().getClass().getClassLoader();

        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile());
        }

    }
}
