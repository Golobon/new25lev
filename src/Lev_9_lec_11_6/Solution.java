package Lev_9_lec_11_6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        List<String> listResult = getResultStrings(getStringLineList(selectPath()));
        listResult.forEach(System.out::println);
    }

    public static String selectPath() throws IOException {
        String path;
        try (BufferedReader bR = new BufferedReader(new InputStreamReader(System.in))) {
            path = bR.readLine();
        }
        return path;
    }

    public static List<String> getStringLineList(String path) throws IOException {
        List<String> list = new ArrayList<>();
        try (BufferedReader bRF = new BufferedReader(new FileReader(path))) {
            while (bRF.ready()) {
                list.add(bRF.readLine());
            }
        }
        return list;
    }

    public static List<String> getResultStrings(List<String> list) {
        List<String> listResut = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            String[] strArr = list.get(i).split(" ");
            for (int k = 0; k < strArr.length; k++) {
                for (int j = 0; j < words.size(); j++) {
                    if (strArr[k].equals(words.get(j))) count++;
                }
            }
            if (count == 2) {
                listResut.add(list.get(i));
            }
        }
        return listResut;
    }
}
