package org.example;

import java.util.Objects;

public class Book {
    private final String id;
    private final String title;
    private final String author;
    private final String genre;
    private final int year;
    private final String isbn;

    public Book(String id, String title, String author, String genre, int year, String isbn) {
        this.id = Objects.requireNonNull(id, "Id es requerido.");
        this.title = title == null ? "" : title;
        this.author = author== null ? "" : author;
        this.genre = genre == null ? "" : genre;
        this.year = year;
        this.isbn = isbn == null ? "" : isbn;
    }

    public String toCsvLine() {
        return String.join(";",
                id,
                title,
                author,
                genre,
                Integer.toString(year),
                isbn);
    }

    public static Book fromCsvParts(String[] parts) {
        if (parts.length < 6) {
            throw new IllegalArgumentException("Csv no válido para un libro. Son necesarias 6 columnas.");
        }
        String id = parts[0];
        String title = parts[1];
        String author = parts[2];
        String genre = parts[3];
        int year;
        try {
            year = Integer.parseInt(parts[4]);
        } catch (NumberFormatException e) {
            year = 0;
        }
        String isbn = parts[5];
        return new Book(id, title, author, genre, year, isbn);
    }

    @Override
    public String toString() {
        return "[" + id + "] " + title + " — " + author + " (" + year + ") [" + genre + "] ISBN:" + isbn;
    }
}
