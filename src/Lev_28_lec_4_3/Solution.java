package Lev_28_lec_4_3;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/*
Загрузчик файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("C:\\Users\\Администратор\\Desktop\\Java\\1"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        URL url = new URL(urlString);

        InputStream inpStrUrl = url.openStream();

        String[] urlName = urlString.split("/");

        String finFileName = urlName[urlName.length - 1];

        Path tempFile = Files.createTempFile("", "");

        Files.copy(inpStrUrl, tempFile, StandardCopyOption.REPLACE_EXISTING);

        Path newFileName = Path.of(downloadDirectory + "\\" + finFileName);

        Files.move(tempFile, newFileName);

        return newFileName;
    }
}
