package kz.edu.astana.it.visitor;

public interface FileSystemVisitor {
    void visit(File file);
    void visit(Directory directory);
}