package Lev_29_lec_4_3;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

/*
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) throws IOException {
        if (reader == null) { return "reader is null"; }
        else { try (StringWriter sW = new StringWriter()) {
            StringBuilder builder = new StringBuilder();
            int charsRead;
            char[] chars = new char[256];
            while ((charsRead = reader.read(chars, 0, chars.length)) != -1) {
                builder.append(chars, 0, charsRead); }
            String stringReadFromReader = builder.toString();
            char[] chars2 = stringReadFromReader.toCharArray();
            for (int i = 0; i < chars2.length; i++) { sW.write((chars2[i] + key)); }
        return sW.toString(); } } } }
