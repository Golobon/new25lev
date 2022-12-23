package Lev_11_lec_10_3;

import java.io.*;
import java.util.logging.Logger;

/*
Сериализация человека
*/

public class Solution {

    public static class Person implements Serializable {
        String firstName;
        String lastName;
        transient String fullName;
        transient final String greeting;
        String country;
        Sex sex;
        transient PrintStream outputStream;
        transient Logger logger;

        Person(String firstName, String lastName, String country, Sex sex) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.fullName = String.format("%s, %s", lastName, firstName);
            this.greeting = "Hello, ";
            this.country = country;
            this.sex = sex;
            this.outputStream = System.out;
            this.logger = Logger.getLogger(String.valueOf(Person.class));
        }

        private Object readResolve() {
            return new Person(this.firstName, this.lastName,
                    this.country, this.sex);
        }
    }

    enum Sex {
        MALE,
        FEMALE
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bAOS = new ByteArrayOutputStream();
        ObjectOutputStream oOS = new ObjectOutputStream(bAOS);
        Person p = new Person("Bob", "Petrov", "Russia", Sex.MALE);
        oOS.writeObject(p);

        ByteArrayInputStream bAIS = new ByteArrayInputStream(bAOS.toByteArray());
        ObjectInputStream oIS = new ObjectInputStream(bAIS);
        Person pCl = (Person) oIS.readObject();
        System.out.println(pCl.firstName);
        System.out.println(pCl.lastName);
        System.out.println(pCl.fullName);
        System.out.println(pCl.greeting);
        System.out.println(pCl.country);
        System.out.println(pCl.sex);
    }
}
