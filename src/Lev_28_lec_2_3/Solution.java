package Lev_28_lec_2_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/*
Продвинутый поиск файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        SearchFileVisitor searchFileVisitor = new SearchFileVisitor();

        //searchFileVisitor.setPartOfName("3");
        searchFileVisitor.setPartOfContent("Bob");
        //searchFileVisitor.setMinSize(50);
        //searchFileVisitor.setMaxSize(10000);

        Files.walkFileTree(Paths.get("C:\\Users\\Администратор\\Desktop\\Java\\1"), searchFileVisitor);

        List<Path> foundFiles = searchFileVisitor.getFoundFiles();
        for (Path file : foundFiles) {
            System.out.println(file);
        }
    }

}
