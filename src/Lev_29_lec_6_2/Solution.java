package Lev_29_lec_6_2;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/*
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); } //true

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {
        ByteArrayInputStream bAIS = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        StringBuilder sB = new StringBuilder();
        try { MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] buffer = new byte[8192];
            int numOfBytesRead;
            while( (numOfBytesRead = bAIS.read(buffer)) > 0) { md.update(buffer, 0, numOfBytesRead); }
            byte[] hash = md.digest();
            for (byte b : hash) { sB.append(String.format("%02X", b).toLowerCase());
            } } catch (Exception ex) { }
        System.out.println(sB);
        System.out.println(md5);
        return sB.toString().equals(md5); } }
