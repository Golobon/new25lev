package Lev_28_lec_4_5;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.util.*;

/*
Что внутри папки?
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        String path = bR.readLine(); bR.close();
        int dir = 0, noDir = 0, fileSize = 0;

        if (!Files.isDirectory(Paths.get(path))) System.out.printf(path + " - не папка");

        else { Queue<File> fileTree = new PriorityQueue<>();
            File file = new File(path);
            Collections.addAll(fileTree, Objects.requireNonNull(file.listFiles()));

            while (!fileTree.isEmpty()) {
                File currentFile = fileTree.remove();

                if (currentFile.isDirectory()) {
                    Collections.addAll(fileTree, Objects.requireNonNull(currentFile.listFiles()));
                    dir++; }

                else { noDir++; fileSize += currentFile.length(); } } }

            System.out.println("Всего папок - " + dir);
            System.out.println("Всего файлов - " + noDir);
            System.out.println("Общий размер - " + fileSize); } }

