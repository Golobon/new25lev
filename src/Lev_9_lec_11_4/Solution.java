package Lev_9_lec_11_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/*
Считаем зарплаты
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        getKeyVithMaxVal(args[0]).forEach(System.out::println);
    }
    public static Set<String> getKeyVithMaxVal(String path) throws IOException {
        Map<String, Double> map = new TreeMap<>();
        Set<String> treeSet = new TreeSet<>();
        double maxVal = 0;
        try (BufferedReader bRF = new BufferedReader(new FileReader(path))) {
            while (bRF.ready()) {
                String[] str = bRF.readLine().split(" ");
                String key = str[0];
                double value = Double.parseDouble(str[1]);
                if (map.containsKey(key)) {
                    value = value + map.get(key);
                    map.replace(key, value);
                    if (map.get(key) > maxVal) {
                        maxVal = map.get(key); } }
                map.put(key, value);
                if (map.get(key) > maxVal) { maxVal = map.get(key); } } }

        for (String x : map.keySet()) {
            if (map.get(x).equals(maxVal)) {
                treeSet.add(x); } }
        return treeSet; }
}
