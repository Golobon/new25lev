package Lev_10_lec_2_2;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Читаем и пишем в файл: JavaRush
*/

public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = new File("111.big");
            //File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();

            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут

            User user1 = new User();
            user1.setFirstName("Bob1");
            user1.setLastName("Petrov1");
            user1.setBirthDate(new Date(1999 - 1900, 10 - 1, 11));
            user1.setCountry(User.Country.RUSSIA);
            user1.setMale(true);

            User user2 = new User();
            user2.setFirstName("Bob2");
            user2.setLastName("Petrov2");
            user2.setBirthDate(new Date(1998 - 1900, 11 - 1, 12));
            user2.setCountry(User.Country.UKRAINE);
            user2.setMale(false);

            User user3 = new User();
            user3.setFirstName("Bob3");
            user3.setLastName("Petrov3");
            user3.setBirthDate(new Date(1997 - 1900, 12 - 1, 13));
            user3.setCountry(User.Country.OTHER);
            user3.setMale(true);

            javaRush.users.add(user1);
            javaRush.users.add(user2);
            javaRush.users.add(user3);

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);

            //here check that the javaRush object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны

            System.out.println(javaRush.hashCode() == loadedObject.hashCode());
            System.out.println(javaRush.equals(loadedObject));

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            BufferedOutputStream bOS = new BufferedOutputStream(outputStream);
            if (users.size() != 0) {
                bOS.write("notNull".getBytes());
                bOS.write(";".getBytes());
                bOS.write(String.valueOf(users.size()).getBytes());
                bOS.write(";".getBytes());

                for (int i = 0; i < users.size(); i++) {
                bOS.write(users.get(i).getFirstName().getBytes());
                    bOS.write(";".getBytes());

                    bOS.write(users.get(i).getLastName().getBytes());
                    bOS.write(";".getBytes());

                    bOS.write(String.valueOf(users.get(i).getBirthDate().getTime()).getBytes());
                    bOS.write(";".getBytes());

                    bOS.write(users.get(i).getCountry().toString().getBytes());
                    bOS.write(";".getBytes());

                    bOS.write(String.valueOf(users.get(i).isMale()).getBytes());
                    bOS.write(";".getBytes());
                }
            } else {
                bOS.write("Null".getBytes());
                System.out.println("Список \"users\" пустой");
            }
            bOS.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedInputStream bIS = new BufferedInputStream(inputStream);
            StringBuilder sB = new StringBuilder();
            byte[] bytes = new byte[bIS.available()];

            for (int i = 0; i < bytes.length; i++) {
                bytes[i] = (byte) bIS.read();
            }

            for (int i = 0; i < bytes.length; i++) {
                sB.append((char)(bytes[i]));
            }
            String[] mem = sB.toString().split(";");

            if (mem[0].equals("notNull")) {

                int CountFirstName = 2;
                int CountLasName = 3;
                int CountBirthDay = 4;
                int CountCountry = 5;
                int CountMale = 6;

                for (int i = 0; i < Integer.parseInt(mem[1]); i++) {
                    User user = new User();

                    user.setFirstName(mem[CountFirstName]);

                    user.setLastName(mem[CountLasName]);

                    user.setBirthDate(new Date(Long.parseLong((mem[CountBirthDay]))));

                    switch (mem[CountCountry]) {
                        case "RUSSIA" : user.setCountry(User.Country.RUSSIA); break;
                        case "UKRAINE" : user.setCountry(User.Country.UKRAINE); break;
                        case "OTHER" : user.setCountry(User.Country.OTHER); break;
                    }

                    user.setMale(Boolean.parseBoolean(mem[CountMale]));

                    this.users.add(user);

                    CountFirstName = CountFirstName + 5;
                    CountLasName = CountLasName + 5;
                    CountBirthDay = CountBirthDay + 5;
                    CountCountry = CountCountry + 5;
                    CountMale = CountMale + 5;
                }
            } else System.out.println("Список \"users\" пустой");
            bIS.close();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
