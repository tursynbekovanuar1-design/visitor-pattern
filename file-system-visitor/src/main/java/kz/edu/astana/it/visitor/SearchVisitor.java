package kz.edu.astana.it.visitor;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String nameQuery;
    private List<File> foundFiles = new ArrayList<>();

    public SearchVisitor(String nameQuery) {
        this.nameQuery = nameQuery;
    }

    @Override
    public void visit(File file) {
        if (file.getName().toLowerCase().contains(nameQuery.toLowerCase())) {
            foundFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
        // Traverse all children to search inside subdirectories
        for (FileSystemElement element : directory.getChildren()) {
            element.accept(this);
        }
    }

    public List<File> getFoundFiles() {
        return foundFiles;
    }
}