package Lev_28_lec_2_2;

import java.io.File;
import java.io.IOException;
import java.util.*;

/*
Находим все файлы
*/

public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        File file = new File(root);
        List<String> result = new ArrayList<>();
        Queue<File> fileTree = new PriorityQueue<>();

        Collections.addAll(fileTree, Objects.requireNonNull(file.listFiles()));

        while (!fileTree.isEmpty()) {
            File currentFile = fileTree.remove();
            if(currentFile.isDirectory()) Collections.addAll(fileTree, Objects.requireNonNull(currentFile.listFiles()));
            else result.add(currentFile.getAbsolutePath());
        } return result; }

    public static void main(String[] args) throws IOException {
        getFileTree("C:\\Users\\Администратор\\Desktop\\Java\\1").forEach(System.out::println);
    }
}

