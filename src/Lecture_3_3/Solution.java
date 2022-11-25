package Lecture_3_3;

import java.util.HashMap;
import java.util.Map;

/*
Адаптация нескольких интерфейсов
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static  {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        IncomeDataAdapter iDA = new IncomeDataAdapter(new Test());
        System.out.println(iDA.getCompanyName());
        System.out.println(iDA.getCountryName());
        System.out.println(iDA.getName());
        System.out.println(iDA.getPhoneNumber());
    }

    public static class IncomeDataAdapter implements Customer, Contact {

         private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            String number = "";
            int x = 10 - String.valueOf(data.getPhoneNumber()).length();
            if (x>0) {
                for (int i = 0; i < x; i++) {
                    number = number + "0";
                }
            }
            number = number + data.getPhoneNumber();
            String cityCode = number.substring(0,3);
            String phoneNumber = number.substring(3,6) + "-" +  number.substring(6,8) + "-" +  number.substring(8);
            return "+" + data.getCountryPhoneCode() + "(" + cityCode + ")" + phoneNumber;
        }
    }

    public static class Test implements IncomeData {
        public String getCountryCode() {
            return "UA";
        }        //For example: UA

        public String getCompany() {
            return "JavaRush Ltd.";
        }            //For example: JavaRush Ltd.

        public String getContactFirstName() {
            return "Ivan";
        }   //For example: Ivan

        public String getContactLastName() {
            return "Ivanov";
        }    //For example: Ivanov

        public int getCountryPhoneCode() {
            return 38;
        }      //For example: 38

        public int getPhoneNumber() {
            return 501234567;
        }           //For example1: 501234567, For example2: 71112233
    }

    public interface IncomeData {
        String getCountryCode() ;        //For example: UA

        String getCompany() ;            //For example: JavaRush Ltd.

        String getContactFirstName() ;   //For example: Ivan

        String getContactLastName() ;    //For example: Ivanov

        int getCountryPhoneCode() ;      //For example: 38

        int getPhoneNumber() ;           //For example1: 501234567, For example2: 71112233
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
    }
}