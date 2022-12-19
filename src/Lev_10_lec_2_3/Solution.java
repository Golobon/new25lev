package Lev_10_lec_2_3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
Знакомство с properties
*/

public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    public static void save(OutputStream outputStream) throws Exception {
        //BufferedOutputStream bOS = new BufferedOutputStream(outputStream);
        Properties prop = new Properties();
        for(Map.Entry<String, String> x: runtimeStorage.entrySet()) {
            prop.setProperty(x.getKey(), x.getValue());
        }
        prop.store(outputStream, "");
        //bOS.close();
    }

    public static void load(InputStream inputStream) throws IOException {
        BufferedInputStream bIS = new BufferedInputStream(inputStream);
        Properties prop = new Properties();
        prop.load(inputStream);
        bIS.close();
        for (String s : prop.stringPropertyNames()) {
            runtimeStorage.put(s, prop.getProperty(s));
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(runtimeStorage);
    }
}
