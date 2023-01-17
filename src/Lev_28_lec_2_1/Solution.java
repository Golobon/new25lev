package Lev_28_lec_2_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/*
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {

        File path = new File(args[0]);
        File source = new File(args[1]);

        File destination  = new File(source.getParent() + "\\" + "allFilesContent.txt");

        FileUtils.renameFile(source, destination);

        List<String> result = new ArrayList<>();
        Queue<File> fileTree = new PriorityQueue<>();

        Collections.addAll(fileTree, Objects.requireNonNull(path.listFiles()));

        while (!fileTree.isEmpty())
        {
            File currentFile = fileTree.remove();
            if(currentFile.isDirectory()){
                Collections.addAll(fileTree, Objects.requireNonNull(currentFile.listFiles()));
            } else {
                if (currentFile.length() > 50 && !currentFile.getName().equals(destination.getName())) result.add(currentFile.getAbsolutePath());
            }
        }

        FileInputStream fIS = null;
        FileOutputStream fOS = new FileOutputStream(destination);
        for (String f : result) {
            fIS = new FileInputStream(f);
            while (fIS.available() >0) {
                fOS.write(fIS.read());
            }
            fOS.write("\n".getBytes());
        }
        if (fIS != null) fIS.close();
        fOS.close();
    }
}
