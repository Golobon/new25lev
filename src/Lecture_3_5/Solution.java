package Lecture_3_5;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
Адаптация нескольких интерфейсов
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        DataAdapter dA = new DataAdapter(new Adapter(), new Adapter());
        System.out.println(dA.getCountryCode());
        System.out.println(dA.getCompany());
        System.out.println(dA.getContactFirstName());
        System.out.println(dA.getContactLastName());
        System.out.println(dA.getDialString());
    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        public String getCountryCode() {
            Collection<String> collection = countries.keySet();
            String desiredObject = customer.getCountryName();//что хотим найти
            String country = "";
            for (String key : collection) {
                String obj = countries.get(key);
                if (key != null) {
                    if (desiredObject.equals(obj)) {
                        country = key;// нашли наше значение и возвращаем  ключ
                    }
                }
            }
            return country;
        }       //For example: UA

        public String getCompany() {
            return customer.getCompanyName();
        }            //For example: JavaRush Ltd.

        public String getContactFirstName() {
            String fN = contact.getName().replace(",", "");
            String[] str = fN.split(" ");
            return str[0];
        }   //For example: Ivan

        public String getContactLastName() {
            String fN = contact.getName().replace(",", "");
            String[] str = fN.split(" ");
            return str[1];
        }    //For example: Ivanov

        public String getDialString() {

            return "callto://" + contact.getPhoneNumber().replaceAll("[()-]", "");
        }         //For example: callto://+380501234567

    }

    public static class Adapter implements Customer, Contact {

        @Override
        public String getCompanyName() {
            return "JavaRush Ltd.";
        }

        @Override
        public String getCountryName() {
            return "Ukraine";
        }

        @Override
        public String getName() {
            return "Ivanov, Ivan";
        }

        @Override
        public String getPhoneNumber() {
            return "+38(050)123-45-67";
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }


    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}
