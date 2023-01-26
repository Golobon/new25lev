package Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
public class Sverka {
    public static void main(String[] args) throws IOException {

        List<Path> list1 = new ArrayList<>();
        List<Path> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();

        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(bR.readLine());
        Path path2 = Paths.get(bR.readLine());
        bR.close();
        Files.walkFileTree(path, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                list1.add(file);
                return FileVisitResult.CONTINUE;
            }
        });


        Files.walkFileTree(path2, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                list2.add(file);
                return FileVisitResult.CONTINUE;
            }
        });

        for (int i = 0; i < list1.size(); i++) {
            for (int b = 0; b < list2.size(); b++) {
                if (list1.get(i).toString().substring(6).equals(list2.get(b).toString().substring(6))) {
                    System.out.println(list1.get(i).toString().substring(6));
                    System.out.println(list2.get(b).toString().substring(6));
                    System.out.println(list1.get(i).toString().substring(6).equals(list2.get(b).toString().substring(6)));
                    list2.remove(list2.get(b)); b--;
                }
            }
        }

        System.out.println();
        System.out.println("Проверка пути");
        System.out.println();

        for (int i = 0; i < list2.size(); i++) {
            System.out.println(list2.get(i).getFileName().toString());
            System.out.println(list2.get(i).getFileName().toString().startsWith("~$"));
            if (list2.get(i).getFileName().toString().startsWith("~$")) {
                list2.remove(list2.get(i)); i--;
            }
        }

//        E:\\3\\a
//        E:\\3\\b

        System.out.println();
        System.out.println("Новый файлы:");
        System.out.println();

        for (Path x : list2) {
            System.out.println(x);
        }
    }
}

