package Lev_28_lec_4_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Solution_2 {
    static AtomicInteger aDir = new AtomicInteger(0), aNoDir = new AtomicInteger(0);
    static AtomicLong aFileSize = new AtomicLong(0);
    static int d = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bR = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(bR.readLine()); bR.close();

        if (!Files.isDirectory(path)) System.out.printf(path + " - не папка");
        else { Files.walkFileTree(path, new SimpleFileVisitor<Path>(){

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
                d++; aDir.incrementAndGet(); return FileVisitResult.CONTINUE; }
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                aNoDir.incrementAndGet(); aFileSize.getAndAdd(file.toFile().length()); return FileVisitResult.CONTINUE; } });

            System.out.println("Всего папок - " + aDir.decrementAndGet());
            System.out.println("Всего файлов - " + aNoDir.get());
            System.out.println("Общий размер - " + aFileSize.get());} } }
