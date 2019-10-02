package com.epam.lambdasstreams.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Book {

    private String title;
    private int countOfPages;
    private List<Author> authors;

    public Book(String title, int countOfPages) {
        this.title = title;
        this.countOfPages = countOfPages;
        this.authors = new ArrayList<>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCountOfPages() {
        return countOfPages;
    }

    public void setCountOfPages(int countOfPages) {
        this.countOfPages = countOfPages;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return getCountOfPages() == book.getCountOfPages() &&
                getTitle().equals(book.getTitle()) &&
                getAuthors().equals(book.getAuthors());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getCountOfPages());
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", numberOfPages=" + countOfPages +
                '}';
    }

}
