package Lev_9_lec_11_9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Длинные слова
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String readFrom = args[0];
        String pathToWrite = args[1];
        String Strings = getStringsFromFile(readFrom);
        List<String> listWithWOrdsResut = getListWIthResultWords(Strings);
        writeToFile(pathToWrite, listWithWOrdsResut); }

    public static String getStringsFromFile(String path) throws IOException {
        StringBuilder sB = new StringBuilder();
        try (BufferedReader bRF = new BufferedReader(new FileReader(path))) {
            while (bRF.ready()) {
                sB.append((char)bRF.read()); } }
        return sB.toString(); }

    public static List<String> getListWIthResultWords(String words) {
        String[] srtArr = words.split("[\\n\\r ]");
        List<String> x = new ArrayList<>();
        for (int i = 0; i < srtArr.length; i++) {
            if (srtArr[i].length() > 6) {
                x.add(srtArr[i]); } }
        return x; }

    public static void writeToFile(String path, List<String> list) throws IOException {
        try (BufferedWriter bW = new BufferedWriter(new FileWriter(path))) {
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) { bW.write(list.get(i)); break; }
                bW.write(list.get(i) + ","); } } } }
