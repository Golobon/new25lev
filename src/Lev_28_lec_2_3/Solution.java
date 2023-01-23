package Lev_28_lec_2_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/*
Продвинутый поиск файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        SearchFileVisitor searchFileVisitor = new SearchFileVisitor();

        searchFileVisitor.setPartOfName("");
        searchFileVisitor.setPartOfContent("Bob");
        searchFileVisitor.setMinSize(0);
        searchFileVisitor.setMaxSize(0);

        Path path = Path.of("C:\\Users\\G\\Desktop\\java\\1");
        Files.walkFileTree(path, searchFileVisitor);

        List<Path> foundFiles = searchFileVisitor.getFoundFiles();
        for (Path file : foundFiles) {
            System.out.println(file);
        }
    }

}
