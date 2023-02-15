package Lev_29_lec_2_1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
Запись в существующий файл
*/

public class Solution {
    public static void main(String... args) throws IOException {
        try (RandomAccessFile rAF = new RandomAccessFile(args[0], "rw")) {
            rAF.seek(Integer.parseInt(args[1]));
            byte[] buff = new byte[args[2].getBytes().length];
            rAF.read(buff, 0, args[2].getBytes().length);
            rAF.seek(rAF.length());
            if (new String(buff).equals(args[2])) rAF.write("true".getBytes());
            else rAF.write("false".getBytes());
        }
    catch (FileNotFoundException e) { } } }