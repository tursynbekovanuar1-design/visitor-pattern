package kz.edu.astana.it.visitor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем структуру объектов (файловую систему)
        Directory root = new Directory("root");

        Directory documents = new Directory("Documents");
        documents.addElement(new File("resume.pdf", 1500));
        documents.addElement(new File("report.docx", 2300));

        Directory music = new Directory("Music");
        music.addElement(new File("song.mp3", 5000));
        music.addElement(new File("notes.txt", 120));

        root.addElement(documents);
        root.addElement(music);
        root.addElement(new File("root_note.txt", 45));

        System.out.println("=== 1. Visitor: Size Calculator ===");
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total File System Size: " + sizeVisitor.getTotalSize() + " bytes");

        System.out.println("\n=== 2. Visitor: Search Files ===");
        SearchVisitor searchVisitor = new SearchVisitor("txt");
        root.accept(searchVisitor);
        List<File> foundFiles = searchVisitor.getFoundFiles();
        System.out.println("Found files matching '.txt':");
        for (File file : foundFiles) {
            System.out.println(" - " + file.getName() + " (" + file.getSize() + " bytes)");
        }
    }
}