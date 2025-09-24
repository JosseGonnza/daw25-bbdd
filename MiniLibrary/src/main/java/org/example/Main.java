package org.example;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    private static  final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        BookStore bookStore = new BookStore();

        System.out.println("Welcome to MiniLibrary!");

        while (true) {
            System.out.println("\nElige una opción:\n" +
                    "1) Añadir libro\n" +
                    "2) Listado de libros\n" +
                    "3) Salir");
            String option = scanner.nextLine().trim();
            try {
                switch (option) {
                    case "1" -> addBook(bookStore);
                    case "2" -> listBooks(bookStore);
                    case "3" -> { System.out.println("Saliendo!"); return;}
                    default -> System.out.println("Opción no válida.");
                }
            } catch (Exception e) {
                System.err.println("Error: " + e.getMessage());
            }
        }
    }

    private static void listBooks(BookStore bookStore) {
        List<Book> list = bookStore.FindAll();
        if (list.isEmpty()) {
            System.out.println("No hay libros aún!");
            return;
        }
        for (Book b : list) {
            System.out.println(b);
        }
    }

    private static void addBook(BookStore bookStore) throws IOException {
        System.out.println("Título: ");
        String title = CsvUtil.sanitize(scanner.nextLine());
        System.out.println("Autor: ");
        String author = CsvUtil.sanitize(scanner.nextLine());
        System.out.println("Género: ");
        String genre = CsvUtil.sanitize(scanner.nextLine());
        System.out.println("Año: ");
        int year = 0;
        try {
            year = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Año no válido. Añadido año 0.");
        }
        System.out.println("ISBN: ");
        String isbn = CsvUtil.sanitize(scanner.nextLine());
        String id = UUID.randomUUID().toString();
        Book book = new Book(id, title, author, genre, year, isbn);
        bookStore.add(book);
        System.out.println("Guardado ✅");
    }
}