package com.marcos.biblioteca.repository;

import com.marcos.biblioteca.model.Book;
import com.marcos.biblioteca.model.ReadingStatus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InMemoryBookRepository implements BookRepository {
    private final List<Book> books;

    public InMemoryBookRepository() {
        this.books = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        if (this.books.contains(book)) {
            throw new IllegalArgumentException("Book already exists");
        }
        this.books.add(book);
    }

    @Override
    public List<Book> listBooks() {
        return Collections.unmodifiableList(this.books);
    }

    @Override
    public void updateStatus(Book book, ReadingStatus status) {
        if (!this.books.contains(book)) {
            throw new IllegalArgumentException("Book doesn't exist!");
        }
        if (book.getStatus().equals(status)) {
            throw new IllegalArgumentException("The book already have this status!");
        }
        book.setStatus(status);
    }

    @Override
    public void removeBook(Book book) {
        if (!this.books.contains(book)) {
            throw new IllegalArgumentException("Book doesn't exist!");
        }
        books.remove(book);

    }
}
