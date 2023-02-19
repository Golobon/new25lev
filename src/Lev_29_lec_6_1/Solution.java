package Lev_29_lec_6_1;

import java.io.ByteArrayOutputStream;

/*
Генератор паролей
*/
//97 + 122
//65 + 90
//48 + 57
public class Solution {
    public static void main(String[] args) {
//        char registered = '0';
//        int code = (int) registered;
//        System.out.println(registered + " значит " + code);
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString()); }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream bAOS = new ByteArrayOutputStream();
        int[] val = new int[3];
        bAOS.write(rnd(97, 122));
        bAOS.write(rnd(65, 90));
        bAOS.write(rnd(48, 57));
        for (int i = 0; i < 5; i++) {
            val[0] = rnd(97, 122);
            val[1] = rnd(65, 90);
            val[2] = rnd(48, 57);
            bAOS.write(val[rnd(0, 2)]); }
        return bAOS; }

    public static int rnd(int min, int max) {
        max -= min; return (int) (Math.random() * ++max) + min; } }
