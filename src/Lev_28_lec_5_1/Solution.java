package Lev_28_lec_5_1;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        unpackZipFile(unitZipFileParts(args), args[0]);
    }

    public static File unitZipFileParts(String... x) throws IOException {
        Set<String> files = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String[] parts1 = o1.split("\\.");
                String[] parts2 = o2.split("\\.");
                int number1 = Integer.parseInt(parts1[parts1.length - 1]);
                int number2 = Integer.parseInt(parts2[parts2.length - 1]);
                return number1 - number2;
            }
        });

        for (int i = 1; i < x.length; i++) {
            files.add(x[i]);
        }

        String outputFile = x[0] + ".zip";

        try (FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {
            for (String file : files) {
                try (FileInputStream fileInputStream = new FileInputStream(file)) {
                    byte[] buffer = new byte[fileInputStream.available()];
                    while (fileInputStream.available() > 0) {
                        int bytesRead = fileInputStream.read(buffer);
                        fileOutputStream.write(buffer, 0, bytesRead);
                    }
                }
            }
        }
        return new File(outputFile);
    }

    public static void unpackZipFile(File zipFile, String resultPath) throws IOException {
        byte[] buffer;
        try (FileInputStream fIS = new FileInputStream(zipFile);
             ZipInputStream zIS = new ZipInputStream(fIS, Charset.forName("windows-1251"))) {
                ZipEntry zE = zIS.getNextEntry();
                buffer = new byte[(int) zE.getSize()];
                for (int i = 0; i < buffer.length; i++) {
                    buffer[i] = (byte) zIS.read();
                }
        }
        try (FileOutputStream fOS = new FileOutputStream(resultPath)) {
            fOS.write(buffer);
        }
    }
}
