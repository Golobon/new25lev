package Lev_28_lec_5_1;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/

public class Solution_3 {
    public static void main(String[] args) throws IOException {

        List<String> files = new ArrayList<>();

        List<FileInputStream> listPartsFiles = new ArrayList<>();

        for (int i = 1; i < args.length; i++) { files.add(args[i]); }
        Collections.sort(files);

        for (String s : files) { listPartsFiles.add(new FileInputStream(s)); }

        ByteArrayOutputStream bAOS = new ByteArrayOutputStream();
            for (String file : files) {
                try (FileInputStream fileInputStream = new FileInputStream(file)) {
                    byte[] buffer = new byte[fileInputStream.available()];
                    while (fileInputStream.available() > 0) {
                        int bytesRead = fileInputStream.read(buffer);
                        bAOS.write(buffer, 0, bytesRead); } } }

        try (ZipInputStream zIS = new ZipInputStream(
                new ByteArrayInputStream(bAOS.toByteArray()), Charset.forName("windows-1251"));
             FileOutputStream fOS = new FileOutputStream(args[0])) {
                byte[] buff = new byte[4096];
                int buffMass;
                ZipEntry zentry;
                while ((zentry = zIS.getNextEntry()) != null) while ((buffMass = zIS.read(buff)) > 0) {
                fOS.write(buff, 0, buffMass); } } } }

