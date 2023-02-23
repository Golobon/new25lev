package Sverka;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.text.SimpleDateFormat;
import java.util.*;

public class Sverka {
    public static void getAfter(String PathFileBefore, String PathFileAfter, String PathToCreateFile) throws IOException {

        List<Path> list1 = new ArrayList<>();
        List<Path> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();

        Path path = Paths.get(PathFileBefore);
        Path path2 = Paths.get(PathFileAfter);
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                return FileVisitResult.CONTINUE; }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                list1.add(file); return FileVisitResult.CONTINUE; } });


        Files.walkFileTree(path2, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                return FileVisitResult.CONTINUE;            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                list2.add(file); return FileVisitResult.CONTINUE; } });



        for (int i = 0; i < list1.size(); i++) {
            for (int b = 0; b < list2.size(); b++) {
                if (list1.get(i).toString().substring(6).equals(list2.get(b).toString().substring(6))) {
//                    System.out.println(list1.get(i).toString().substring(6));
//                    System.out.println(list2.get(b).toString().substring(6));
//                    System.out.println(list1.get(i).toString().substring(6).equals(list2.get(b).toString().substring(6)));
                    list2.remove(list2.get(b)); b--;
                }
            }
        }

//        System.out.println();
//        System.out.println("Проверка пути");
//        System.out.println();

        for (int i = 0; i < list2.size(); i++) {
//            System.out.println(list2.get(i).getFileName().toString());
//            System.out.println(list2.get(i).getFileName().toString().startsWith("~$"));
            if (list2.get(i).getFileName().toString().startsWith("~$")) {
                list2.remove(list2.get(i)); i--;
            }
        }

//        E:\\3\\a - директории с файлами (было)
//        E:\\3\\b - директории с файлами (стало)

//        System.out.println();
//        System.out.println("Новые файлы:");
//        System.out.println();

        for (Path x : list2) {
//            System.out.println(x);
            list3.add(x.toString().substring(7));
        }

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH-mm-ss z");
        Date date = new Date(System.currentTimeMillis());
        String sss = formatter.format(date);

        FileWriter fW = new FileWriter(PathToCreateFile + "\\Новые файлы на " + sss + ".txt");
        BufferedWriter bW = new BufferedWriter(fW);
        for (String x : list3) {
            bW.write(x);
        }
        bW.flush();
        bW.close();
    }

    public static void findDeletedFiles(String PathFileBefore, String PathFileAfter, String PathToCreateFile) throws IOException {

        List<Path> list1 = new ArrayList<>();
        List<Path> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();

        Path path2 = Paths.get(PathFileBefore);
        Path path = Paths.get(PathFileAfter);
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                return FileVisitResult.CONTINUE; }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                list1.add(file); return FileVisitResult.CONTINUE; } });


        Files.walkFileTree(path2, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                return FileVisitResult.CONTINUE;            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                list2.add(file); return FileVisitResult.CONTINUE; } });



        for (int i = 0; i < list1.size(); i++) {
            for (int b = 0; b < list2.size(); b++) {
                if (list1.get(i).toString().substring(6).equals(list2.get(b).toString().substring(6))) {
//                    System.out.println(list1.get(i).toString().substring(6));
//                    System.out.println(list2.get(b).toString().substring(6));
//                    System.out.println(list1.get(i).toString().substring(6).equals(list2.get(b).toString().substring(6)));
                    list2.remove(list2.get(b)); b--;
                }
            }
        }

//        System.out.println();
//        System.out.println("Проверка пути");
//        System.out.println();

        for (int i = 0; i < list2.size(); i++) {
//            System.out.println(list2.get(i).getFileName().toString());
//            System.out.println(list2.get(i).getFileName().toString().startsWith("~$"));
            if (list2.get(i).getFileName().toString().startsWith("~$")) {
                list2.remove(list2.get(i)); i--;
            }
        }

//        E:\\3\\a - директории с файлами (было)
//        E:\\3\\b - директории с файлами (стало)

//        System.out.println();
//        System.out.println("Новые файлы:");
//        System.out.println();

        for (Path x : list2) {
//            System.out.println(x);
            list3.add(x.toString().substring(7));
        }

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH-mm-ss z");
        Date date = new Date(System.currentTimeMillis());
        String sss = formatter.format(date);

        FileWriter fW = new FileWriter(PathToCreateFile + "\\Удаленные файлы на " + sss + ".txt");
        BufferedWriter bW = new BufferedWriter(fW);
        for (String x : list3) {
            bW.write(x);
        }
        bW.flush();
        bW.close();
    }
}

