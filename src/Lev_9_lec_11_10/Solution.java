package Lev_9_lec_11_10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String readFrom = selectPath();
        List<String> list = getStringsFromFile(readFrom);
        System.out.println(reverseString(list)); }

    public static String selectPath() throws IOException {
        String path;
        try (BufferedReader bR = new BufferedReader(new InputStreamReader(System.in))) {
            path = bR.readLine();
        }
        return path;
    }

    public static List<String> getStringsFromFile(String path) throws IOException {
        List<String> list = new ArrayList<String>();
        try (BufferedReader bRF = new BufferedReader(new FileReader(path))) {
            while (bRF.ready()) {
                list.add(bRF.readLine()); } }
        return list; }

    public static String reverseString(List<String> list) {
        StringBuilder sB = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            char[] srtArr = list.get(i).toCharArray();
            for (int i1 = srtArr.length - 1; i1 >= 0; i1--) {
                sB.append(srtArr[i1]);
            }
            if (i == list.size()-1) break;
            sB.append("\n");
        }
        return sB.toString(); } }
