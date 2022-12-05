package Lev_9_lec_11_5;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Считаем зарплаты
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        fillPEOPLEList(args[0], PEOPLE);
    }

    public static void fillPEOPLEList(String path, List PEOPLE) throws IOException {
        try (BufferedReader bRF = new BufferedReader(new FileReader(path))) {
            StringBuilder sB;
            Person person;
            Date birthDate;
            while (bRF.ready()) {
                String[] str = bRF.readLine().split(" ");
                birthDate = new Date(Integer.parseInt(str[str.length - 1]) - 1900,
                                     Integer.parseInt(str[str.length - 2]) - 1,
                                     Integer.parseInt(str[str.length - 3]));
                sB = new StringBuilder();
                for (int i = 0; i < str.length - 3; i++) {
                    sB.append(str[i]).append(" ");
                }
                person = new Person(sB.toString().substring(0,sB.length()-1), birthDate);
                //System.out.println(sB.length());
                //System.out.println(person.getName() + " " + person.getBirthDate());
                PEOPLE.add(person);
            }
        }
    }
}
