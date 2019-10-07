package com.epam.lambdasstreams.task4;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Author {

    private String name;
    private int age;
    private List<Book> books;

    public Author(String name, int age) {
        this.name = name;
        this.age = age;
        this.books = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Author author = (Author) o;
        return getAge() == author.getAge() &&
                getName().equals(author.getName()) &&
                getBooks().equals(author.getBooks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge());
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
