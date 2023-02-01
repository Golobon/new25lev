package Lev_28_lec_8_1;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Null Object Pattern
*/

public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        try {
            this.fileData = new ConcreteFileData(Files.isHidden(Paths.get(pathToFile)),
                    Files.isExecutable(Paths.get(pathToFile)),
                            Files.isDirectory(Paths.get(pathToFile)),
                                    Files.isWritable(Paths.get(pathToFile)));
        } catch (Exception e) {
            this.fileData = new NullFileData(e);
            }
    }
    public FileData getFileData() {
        return fileData;
    }
}
