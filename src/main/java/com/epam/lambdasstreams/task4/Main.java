package com.epam.lambdasstreams.task4;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.Comparator.comparing;
import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class Main {

    public static void main(String[] args) {
        Author author1 = new Author("John", 88);
        Author author2 = new Author("Kate", 17);
        Author author3 = new Author("Jim", 27);

        Book book1 = new Book("War and Peace", 100500);
        Book book2 = new Book("Harry Potter", 6666);
        Book book3 = new Book("IT", 1000);
        Book book4 = new Book("Clean code", 400);

        author1.addBook(book1);
        author1.addBook(book2);
        book1.addAuthor(author1);
        book2.addAuthor(author1);
        author2.addBook(book3);
        book3.addAuthor(author2);
        author3.addBook(book4);
        book4.addAuthor(author3);

        Author[] authors = new Author[]{author1, author2, author3};
        Book[] books = new Book[]{book1, book2, book3, book4};

        System.out.println("Are there books with more than 200 pages - " + Stream.of(books).anyMatch(book -> book.getCountOfPages() > 200));
        System.out.println("Book with min count of pages - " + Stream.of(books).min(comparingInt(Book::getCountOfPages)).get());
        System.out.println("Book with max count of pages - " + Stream.of(books).max(comparingInt(Book::getCountOfPages)).get());
        System.out.println("Books with one author:\n");
        Stream.of(books).filter(book -> book.getAuthors().size() == 1).forEach(b -> System.out.println(b.toString()));
        System.out.println("Books sorted by count of pages:\n");
        Stream.of(books).sorted(comparing(Book::getCountOfPages)).forEach(b -> System.out.println(b.toString()));
        System.out.println("Books sorted by count of title:\n");
        Stream.of(books).sorted(comparing(Book::getTitle)).forEach(b -> System.out.println(b.toString()));
        List<String> allTitles = Stream.of(books).map(Book::getTitle).collect(toList());
        System.out.println("All titles:\n");
        allTitles.forEach(System.out::println);
        List<Author> allAuthors = Stream.of(books)
                .map(Book::getAuthors)
                .flatMap(Collection::stream)
                .distinct()
                .peek(System.out::println)
                .collect(toList());
        System.out.println("All authors:\n");
        allAuthors.forEach(a -> System.out.println(a.toString()));
        System.out.println("Books with one author:\n");
        Stream.of(books).parallel().filter(book -> book.getAuthors().size() == 1).forEach(b -> System.out.println(b.toString()));
        Optional<String> biggestBookByAuthor1 = Stream.of(books).filter(b -> b.getAuthors().contains(author1))
                .max(comparing(Book::getCountOfPages)).map(Book::getTitle);
        System.out.println("Biggest book by author1 - " + biggestBookByAuthor1.get());
    }

}
