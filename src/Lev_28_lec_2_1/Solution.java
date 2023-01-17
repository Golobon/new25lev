package Lev_28_lec_2_1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.Map;
import java.util.TreeMap;

/*
Проход по дереву файлов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        System.out.println(args[0] + "\n" + args[1]);
        File path = new File(args[0]);
        File source = new File(args[1]);

        System.out.println(source.getName());
        System.out.println(source.getParent());
        System.out.println(source.getPath());
        System.out.println(source.getAbsolutePath());
        System.out.println(source.getAbsoluteFile());
        System.out.println(source.getCanonicalFile());
        System.out.println(source.getAbsolutePath());

        System.out.println(Arrays.toString(path.listFiles()));

        File destination  = new File(source.getParent() + "\\" + "allFilesContent.txt");

        System.out.println(destination);
        FileUtils.renameFile(source, destination);

        System.out.println(destination.length());
    }
}
