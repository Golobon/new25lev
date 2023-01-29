package Lev_28_lec_5_1;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/

public class Solution_3 {
    public static void main(String[] args) throws IOException {

        List<String> files = new ArrayList<>();

        for (int i = 1; i < args.length; i++) { files.add(args[i]); }

        Collections.sort(files);

        ByteArrayOutputStream bAOS = new ByteArrayOutputStream();
        for (String s : files) { try(FileInputStream fIS = new FileInputStream(s)) {
            bAOS.writeBytes(fIS.readAllBytes()); } }

        try (ZipInputStream zIS = new ZipInputStream(
                new ByteArrayInputStream(bAOS.toByteArray()), Charset.forName("windows-1251"));
             FileOutputStream fOS = new FileOutputStream(args[0])) {
                while ((zIS.getNextEntry()) != null) fOS.write(zIS.readAllBytes()); } } }

