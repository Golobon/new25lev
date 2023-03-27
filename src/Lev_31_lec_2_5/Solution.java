package Lev_31_lec_2_5;

/*
Ханойские башни
*/

public class Solution {
    public static void main(String[] args) {
        int numRings = 3;
        moveRing('A', 'B', 'C', numRings);
    }

    public static void moveRing(char a, char b, char c, int numRings) {
        //напишите тут ваш код
        if (numRings > 2) {
            System.out.println("from " + a + " to " + b);
            moveRing(a, c, b, --numRings);
        }

        if (numRings == 4) {
            System.out.println("from " + a + " to " + b);
            moveRing(a, b, c, --numRings);
            System.out.println("from " + a + " to " + b);
        }

        moveRing(a, c, b, --numRings); } }
