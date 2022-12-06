package Lecture_3_1;

public class Solution {
    public static void main(String[] args) {
        //это пример вывода
        System.out.println("12.".matches("^\\d\\d\\D{0,1}$"));
        String x = "Это стоит 1 бакс, а вот это - 12.";
        x = x.replaceAll( "" + 12, "двенадцать");
        System.out.println(x);
    }
}
