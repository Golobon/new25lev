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
        if (numRings < 11) {
            switch (numRings) {
                case 4 : { System.out.println("from A to B"); break; }
                case 5 : { System.out.println("from A to C"); break; }
                case 6 : { System.out.println("from B to C"); break; }
                case 7 : { System.out.println("from A to B"); break; }
                case 8 : { System.out.println("from C to A"); break; }
                case 9 : { System.out.println("from C to B"); break; }
                case 10 : { System.out.println("from A to B"); break; }
            }
            moveRing(a, b, c, ++numRings); } } }
