package Lecture_3_1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Bbb {
    public static void main(String[] args) {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH-mm-ss z");
        Date date = new Date(System.currentTimeMillis());
        String sss = formatter.format(date);
        System.out.println(sss);
    }
}
