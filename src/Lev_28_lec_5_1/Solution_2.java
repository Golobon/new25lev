package Lev_28_lec_5_1;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/

public class Solution_2 {
    public static void main(String[] args) throws IOException {

        int a;

        //Создаем сет, куда будем копировать все пути ко всем кусочкам,
        //составляющим окончательный файл. Через компаратор определяем
        //сортировку сета от меньшего к большему. Для этого сравниваем цифры
        //в конце файла

        Set<String> files = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] parts1 = o1.split("\\.");
                String[] parts2 = o2.split("\\.");
                int number1 = Integer.parseInt(parts1[parts1.length - 1]);
                int number2 = Integer.parseInt(parts2[parts2.length - 1]);
                return number1 - number2; } });

        //Заполняем список (сет) путями ко всем кусочкам, начиная с args[1]
        //и до конце независимо от размера масссива args

        for (int i = 1; i < args.length; i++) { files.add(args[i]); }

        //Определяем название файла после склейки его кусочков

        String outputFile = args[0] + ".zip";

        //Склеиваем все кусочки файла в один zip файл

        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            for (String file : files) {
                try (FileInputStream fileInputStream = new FileInputStream(file)) {
                    byte[] buffer = new byte[fileInputStream.available()];
                    while (fileInputStream.available() > 0) {
                        int bytesRead = fileInputStream.read(buffer);
                        fileOutputStream.write(buffer, 0, bytesRead); } } } }

        //Разархивируем полученный zip файл и считываем его содержое в буффер

        byte[] buffer;
        try (FileInputStream fIS = new FileInputStream(outputFile);
             ZipInputStream zIS = new ZipInputStream(fIS, Charset.forName("windows-1251"))) {
            ZipEntry zE = zIS.getNextEntry();
            buffer = new byte[(int) zE.getSize()];
            for (int i = 0; i < buffer.length; i++) { buffer[i] = (byte) zIS.read(); } }

        //Создаем файл с именем, которое приходит в аргументах (args[0]) и
        //копируем в него все байты из буффера. На выходе получем склеенный
        //из кусочков zip файл

        File f = new File(outputFile);
        f.delete();

        try (FileOutputStream fOS = new FileOutputStream(args[0])) { fOS.write(buffer); } } }
