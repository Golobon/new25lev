package Lev_9_lec_11_7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Ищем нужные строки
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        String readFrom = args[0];
        String writeTo = args[1];
        writeToFile(writeTo, getResultWords(getStringWOrds(readFrom)));
    }

    public static String getStringWOrds(String path) throws IOException {
        StringBuilder sB = new StringBuilder();
        try (BufferedReader bRF = new BufferedReader(new FileReader(path))) {
            while (bRF.ready()) {
                sB.append(bRF.readLine()); } }
        return sB.toString();
    }

    public static List<String> getResultWords(String words) {
        String[] strArr = words.split(" ");
        List<String> listResut = new ArrayList<String>();
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].matches("(.*\\d+.*)")) {
                listResut.add(strArr[i]); } }
        return listResut;
    }
    public static void writeToFile(String path, List<String> list) throws IOException {
        try (BufferedWriter bW = new BufferedWriter(new FileWriter(path))) {
            for (int i = 0; i < list.size(); i++) {
                if (i == list.size() - 1) { bW.write(list.get(i)); break; }
                bW.write(list.get(i) + " "); } } }
}
