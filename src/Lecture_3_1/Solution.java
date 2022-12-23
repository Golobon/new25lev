package Lecture_3_1;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Long> list = new ArrayList<>();

        for (int i = 369; i < 372; i++) {
            //System.out.println("Идет число " + i);
            int xLenth = String.valueOf(i).length();
            long val = 1;
            long val2 = 0;
            //System.out.println(xLenth);
            char[] ch = String.valueOf(i).toCharArray();
            //System.out.println(ch);
            for (int i1 = 0; i1 < xLenth; i1++) {
                int y = Integer.parseInt(String.valueOf(ch[i1]));
                //System.out.println("виток " + y);
                for (int i2 = 0; i2 < xLenth; i2++) {
                    val = val * y;
                }
                //System.out.println(val);
                val2 = val2 + val;
                //System.out.println(val2);
                val = 1;
            }
            if (i == val2) {
                list.add(val2);
                val2 = 0;
            }

        }
        Long[] i = list.toArray(new Long[0]);
        list.forEach(System.out::println);
        for (long l : i) {
            System.out.println(l);
        }
    }
}