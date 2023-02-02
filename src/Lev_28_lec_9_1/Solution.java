package Lev_28_lec_9_1;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/*
Читаем конфиги
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("src/Lev_28_lec_9_1/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("src/Lev_28_lec_9_1/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("src/Lev_28_lec_9_1/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        Properties properties = new Properties();
        try (FileInputStream fIS = new FileInputStream(fileName)) {
            if (fileName.endsWith(".xml")) {
                properties.loadFromXML(fIS);
            } else properties.load(fIS);
            return properties;
        } catch (IOException e) { return properties; } } }
