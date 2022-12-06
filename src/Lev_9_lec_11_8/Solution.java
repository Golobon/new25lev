package Lev_9_lec_11_8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        String path = selectPath();
        String str = getStringFromFile(path);
        String result = getResultString(str);
        System.out.println(result);
    }

    public static String selectPath() throws IOException {
        String path;
        try (BufferedReader bR = new BufferedReader(new InputStreamReader(System.in))) {
            path = bR.readLine();
        }
        return path;
    }

    public static String getStringFromFile(String path) throws IOException {
        StringBuilder sB = new StringBuilder();
        try (BufferedReader bRF = new BufferedReader(new FileReader(path))) {
            while (bRF.ready()) {
                sB.append((char) bRF.read());
            }
        }
        return sB.toString();
    }

    public static String getResultString(String str) {
        String[] strArr = str.split(" ");
        for (int i = 0; i < strArr.length; i++) {
            for (int x : map.keySet()) {
                strArr[i] = strArr[i].replaceAll("\\b" + x + "\\b", map.get(x));
            }
        }

        StringBuilder sB = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sB.append(strArr[i]).append(" ");
        }
        return sB.toString();
    }
}
