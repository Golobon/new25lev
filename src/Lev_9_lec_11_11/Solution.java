package Lev_9_lec_11_11;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/*
Контекстная реклама
*/

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream sysOut = System.out;
        ByteArrayOutputStream bAOS = new ByteArrayOutputStream();
        PrintStream pS = new PrintStream(bAOS);
        System.setOut(pS);
        testString.printSomething();
        System.setOut(sysOut);
        new PrintArray().printChangedStrings(bAOS);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }

    static class PrintArray {
        public void printChangedStrings(ByteArrayOutputStream bAOS) {
            byte[] byteArray = bAOS.toByteArray();
            int count = 0;
                for (int i = 0; i < byteArray.length; i++) {
                    char ch = (char) byteArray[i];
                    System.out.print(ch);
                if (ch == '\n') {
                    count++;
                }
                if (count == 2) {
                    System.out.println("JavaRush - курсы Java онлайн");
                    count = 0;
                }
            }
        }
    }
}
