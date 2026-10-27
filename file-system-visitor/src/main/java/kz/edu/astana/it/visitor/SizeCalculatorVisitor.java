package kz.edu.astana.it.visitor;

public class SizeCalculatorVisitor implements FileSystemVisitor {
    private long totalSize = 0;

    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getChildren()) {
            element.accept(this);
        }
    }

    public long getTotalSize() {
        return totalSize;
    }
}