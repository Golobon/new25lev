package Lev_11_lec_10_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Алгоритмы-числа
*/

public class Solution {

    public static long[] getNumbers(long N) {
        List<Long> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int xLenth = String.valueOf(i).length();
            long val = 1;
            long val2 = 0;
            char[] ch = String.valueOf(i).toCharArray();
            for (int i1 = 0; i1 < xLenth; i1++) {
                int y = Integer.parseInt(String.valueOf(ch[i1]));
                for (int i2 = 0; i2 < xLenth; i2++) { val = val * y; }
                val2 = val2 + val;
                val = 1; }
            if (i == val2) list.add(val2); }
        long[] x = new long[list.size()];
        for (int i = 0; i < list.size(); i++) { x[i] = list.get(i); }
       return x; }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(Long.MAX_VALUE)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
