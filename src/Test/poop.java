package Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/*
Генератор паролей
*/

public class poop {

    public static void main(String[] args) throws IOException {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            baos.write(newFilledPass());
        } catch (IOException e) {
            System.out.println("Фигня переделывай");
        }
        return baos;

    }

    public static byte[] newFilledPass() {
        byte[] password = new byte[8];

        boolean check1 = false;
        boolean check2 = false;
        boolean check3 = false;

        for (int i = 0; i < password.length; i++) {
            switch (1 + (int) (Math.random() * 3)) {
                case 1: {
                    password[i] = (byte) (48 + (int) (Math.random() * 10));
                    check1 = true;
                    break;
                }
                case 2: {
                    password[i] = (byte) (97 + (int) (Math.random() * 26));
                    check2 = true;
                    break;
                }
                case 3: {
                    password[i] = (byte) (65 + (int) (Math.random() * 26));
                    check3 = true;
                    break;
                }
            }
        }
        if (!check1 || !check2 || !check3) {
            newFilledPass();
        }
        System.out.println(check1 + " " + check2 + " " + check3);
        return password;
    }
}