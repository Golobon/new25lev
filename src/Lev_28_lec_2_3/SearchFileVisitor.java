package Lev_28_lec_2_3;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String PartOfName;
    private String PartOfContent;
    private int MinSize;
    private int MaxSize;
    private List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        PartOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        PartOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        MinSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        MaxSize = maxSize;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        boolean pON = false;
        boolean pOC = false;
        boolean minS = false;
        boolean maxS = false;
        int count = -1;
        if (PartOfName != null || PartOfContent != null || MinSize != 0 || MaxSize != 0) count++;

        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String contentStr = new String(content);

        if (PartOfName != null) { pON = true; count++; }
        if (PartOfContent != null) { pOC = true; count++; }
        if (MinSize != 0) { minS = true; count++; }
        if (MaxSize != 0) { maxS = true; count++; }

        if (pON && file.getFileName().toString().contains(PartOfName)) count--;
        if (pOC && contentStr.contains(PartOfContent)) count--;
        if (minS && new File(String.valueOf(file)).length() > MinSize) count--;
        if (maxS && new File(String.valueOf(file)).length() < MaxSize) count--;

        if (count == 0) getFoundFiles().add(file);

        return super.visitFile(file, attrs);
    }
}
