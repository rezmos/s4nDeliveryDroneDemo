package co.com.domicilio.corrientazo.io;

import java.util.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.io.*;

public class FileUtility {

    public static List<String> readFileInList(String fileName) {

        Path currentRelativePath = Paths.get("");
        String absolutePath = currentRelativePath.toAbsolutePath().toString()+"/addresses/"+fileName;

        List<String> lines = Collections.emptyList();
        try {
            File file = new File(absolutePath);
            lines = Files.readAllLines(Paths.get(file.getPath()), StandardCharsets.UTF_8);
        }
        catch (IOException e) {
            e.printStackTrace();
        }


        return lines;
    }

    public static void writeFile(String fileName, String content) {

        Path currentRelativePath = Paths.get("");
        String absolutePath = currentRelativePath.toAbsolutePath().toString()+"/reports/"+FileUtility.renameFile(fileName, "in");

        try(FileWriter fw = new FileWriter(absolutePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw))
        {
            out.println(content);

        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }
    }

    public static void purgeReportDirectory (){
        Path currentRelativePath = Paths.get("");
        String absolutePath = currentRelativePath.toAbsolutePath().toString()+"/reports/";

        Arrays.stream(new File(absolutePath).listFiles()).forEach(File::delete);

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
