package Lev_10_lec_7_1;

import java.io.*;

/*
Externalizable для апартаментов
*/

public class Solution {

    public static class Apartment implements Externalizable {

        private String address;
        private int year;

        /**
         * Mandatory public no-arg constructor.
         */
        public Apartment() {
            super();
        }

        public Apartment(String addr, int y) {
            address = addr;
            year = y;
        }

        /**
         * Prints out the fields used for testing!
         */
        public String toString() {
            return ("Address: " + address + "\n" + "Year: " + year);
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            if (address != null && year != 0) {
                out.writeObject(address);
                out.writeInt(year);
            }
            out.flush();
            out.close();
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            try {
                address = (String) in.readObject();
                year = in.readInt();

            } catch (ClassNotFoundException | IOException e) {
                System.out.println("Данные для загрузки отсутствуют");
            } finally {
                in.close();
            }
        }
    }

    public static void main(String[] args) {
    }
}
