package kz.edu.astana.it.visitor;

public class File implements FileSystemElement {
    private String name;
    private long size; // size in bytes

    public File(String name, long size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public long getSize() {
        return size;
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this); // Double-dispatch step
    }
}