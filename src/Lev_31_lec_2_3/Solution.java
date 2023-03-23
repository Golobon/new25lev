package Lev_31_lec_2_3;

public class Solution {
    public static void main(String[] args) {
        new Solution().recurse(1592332343);
    }

    public void recurse(int n) {
        if (n > 1) for (int i = 2; i < Integer.MAX_VALUE; i++) {
            if (n % i == 0) {
                System.out.print(i + " ");
                recurse(n / i);
                return;
            }
        }
    }
}
