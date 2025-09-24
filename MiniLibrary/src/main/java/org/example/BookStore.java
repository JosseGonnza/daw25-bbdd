package org.example;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class BookStore {
    private final Path csvFile = Paths.get("data", "books.csv");
    private final List<Book> books = new ArrayList<>();

    public BookStore() {
        try {
            loadFromCsv();
        } catch (IOException e) {
            System.err.println("No existe CSV todavía.");
        }
    }

    public void add(Book book) throws IOException {
        books.add(book);
        saveToCsv();
    }

    public List<Book> FindAll() {
        return List.copyOf(books);
    }

    private void loadFromCsv() throws IOException {
        if (!Files.exists(csvFile)) {
            return;
        } else {
            List<String> lines = Files.readAllLines(csvFile, StandardCharsets.UTF_8);
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i).trim();
                if (line.isEmpty()) continue;
                if (i == 0) continue;
                String[] parts = line.split(";", -1);
                Book b = Book.fromCsvParts(parts);
                books.add(b);
            }
        }
    }

    private void saveToCsv() throws IOException {
        CsvUtil.ensureParentDir(csvFile);
        try (BufferedWriter w = Files.newBufferedWriter(csvFile, StandardCharsets.UTF_8)) {
            w.write("id;title;author;genre;year;isbn");
            w.newLine();
            for (Book b : books) {
                w.write(b.toCsvLine());
                w.newLine();
            }
        }
    }
}
