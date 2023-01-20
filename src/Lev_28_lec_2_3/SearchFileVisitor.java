package Lev_28_lec_2_3;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) { this.maxSize = maxSize; }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        boolean pON = false;
        boolean pOC = false;
        boolean minS = false;
        boolean maxS = false;
        int count = -1;
        if (partOfName != null || partOfContent != null || minSize != 0 || maxSize != 0) count++;

        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        String contentStr = new String(content);

        if (partOfName != null) { pON = true; count++; }
        if (partOfContent != null) { pOC = true; count++; }
        if (minSize != 0) { minS = true; count++; }
        if (maxSize != 0) { maxS = true; count++; }

        if (pON && file.getFileName().toString().contains(partOfName)) count--;
        if (pOC && contentStr.contains(partOfContent)) count--;
        if (minS && content.length > minSize) count--;
        if (maxS && content.length < maxSize) count--;

        if (count == 0) getFoundFiles().add(file);

        return super.visitFile(file, attrs);
    }
}
