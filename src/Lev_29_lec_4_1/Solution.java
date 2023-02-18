package Lev_29_lec_4_1;

import java.io.*;

/*
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString()); }

    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
        if (is == null) { return new StringWriter(); }
        else { try (BufferedInputStream bIS = new BufferedInputStream(is); StringWriter sW = new StringWriter()) {
        byte[] buff = new byte[bIS.available()];
        int i = 0;
        while (bIS.available() > 0) { buff[i++] = (byte) bIS.read(); }
        sW.write(new String(buff));
        return sW; } } } }
