package Lev_10_lec_7_2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Externalizable Person
*/

public class Solution {
    public static class Person implements Externalizable {

        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person() {
            //super();
        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getAge() {
            return age;
        }

        public Person getMother() {
            return mother;
        }

        public Person getFather() {
            return father;
        }

        public List<Person> getChildren() {
            return children;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeUTF(firstName);
            out.writeUTF(lastName);
            out.writeInt(age);
            out.writeObject(children);
            out.flush();
            out.close();
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            setMother((Person) in.readObject());
            setFather((Person) in.readObject());
            setFirstName(in.readUTF());
            setLastName(in.readUTF());
            setAge(in.readInt());
            setChildren((List) in.readObject());
            in.close();;
            in.close();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bAOS = new ByteArrayOutputStream();
        ObjectOutputStream oOS = new ObjectOutputStream(bAOS);
        Person child1 = new Person("Rebz", "Ivanov", 3);
        Person child2 = new Person("Poc", "Ivanov", 5);
        Person man = new Person("Bob", "Ivanov", 23);
        man.setMother(new Person("Mat", "Ivanov", 53));
        man.setFather(new Person("Otec", "Ivanov", 63));
        List<Person> children = new ArrayList<>();
        children.add(child1);
        children.add(child2);
        man.setChildren(children);

        man.writeExternal(oOS);
        bAOS.close();
        oOS.close();

        ByteArrayInputStream bAIS = new ByteArrayInputStream(bAOS.toByteArray());
        ObjectInputStream oIS = new ObjectInputStream(bAIS);

        Person manClone = new Person();
        manClone.readExternal(oIS);
        bAOS.close();
        oIS.close();
        System.out.println(manClone.age + " " + manClone.firstName + " " + manClone.lastName);
    }
}
