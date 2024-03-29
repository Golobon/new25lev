package Lev_31_lec_10_1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

/*
Настраиваем логгер
*/

public class Solution {
    public static void main(String args[]) throws IOException {
        String logProperties = "log4j.properties";
        Path path = Paths.get(logProperties).toAbsolutePath();
        try (InputStream is = new FileInputStream(path.toFile())) {
            Properties properties = new Properties();
            properties.load(is);
        }
    }
}
