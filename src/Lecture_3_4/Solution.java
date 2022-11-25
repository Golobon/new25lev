package Lecture_3_4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/*
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        File file = new File("1");
        PersonScannerAdapter pSA = new PersonScannerAdapter(new Scanner(file));
        System.out.println(pSA.read());
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] arr = fileScanner.nextLine().split(" ");
            Date date = new Date();
            date.setDate(Integer.parseInt(arr[3]));
            date.setMonth(Integer.parseInt(arr[4])-1);
            date.setYear(Integer.parseInt(arr[5])-1900);
            return new Person(arr[1], arr[2], arr[0], date);
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
