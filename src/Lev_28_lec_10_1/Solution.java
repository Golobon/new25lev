package Lev_28_lec_10_1;

import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> list = new CustomTree();

        for (int i = 1; i < 18; i++) {
            list.add(String.valueOf(i));
        }

        System.out.println(list.size());

        System.out.println();

        System.out.println(((CustomTree) list).getParent("16"));
    }
}
