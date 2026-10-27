package kz.edu.astana.it.visitor;

/**
 * Element interface in the Visitor pattern.
 * Declares the accept method to allow visitors to operate on elements.
 */
public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}