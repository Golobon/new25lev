package Lev_29_lec_4_2;

import java.io.PrintWriter;
import java.io.StringWriter;

/*
Пишем стек-трейс
*/

public class Solution {
    public static void main(String[] args) {
        String text = getStackTrace(new IndexOutOfBoundsException("fff"));
        System.out.println(text); }

    public static String getStackTrace(Throwable throwable) {
        try  { throw new IndexOutOfBoundsException(); } catch (Exception e) {
            StringWriter sW = new StringWriter();
            PrintWriter pW = new PrintWriter(sW);
            throwable.printStackTrace(pW);
            return sW.toString(); } } }
