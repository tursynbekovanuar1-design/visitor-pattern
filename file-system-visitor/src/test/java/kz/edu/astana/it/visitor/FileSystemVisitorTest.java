package kz.edu.astana.it.visitor;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FileSystemVisitorTest {

    @Test
    public void testSizeCalculatorVisitor() {
        Directory root = new Directory("root");
        root.addElement(new File("file1.txt", 100));
        root.addElement(new File("file2.txt", 250));

        SizeCalculatorVisitor visitor = new SizeCalculatorVisitor();
        root.accept(visitor);

        assertEquals(350, visitor.getTotalSize());
    }

    @Test
    public void testSearchVisitor() {
        Directory root = new Directory("root");
        root.addElement(new File("report.pdf", 1000));
        root.addElement(new File("notes.txt", 50));

        SearchVisitor visitor = new SearchVisitor("note");
        root.accept(visitor);

        List<File> result = visitor.getFoundFiles();
        assertEquals(1, result.size());
        assertEquals("notes.txt", result.get(0).getName());
    }
}