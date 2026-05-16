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
        this.books.add(book);
    }

    @Override
    public List<Book> listBooks() {
        return Collections.unmodifiableList(this.books);
    }

    @Override
    public void updateStatus(Book book, ReadingStatus status) {
        book.setStatus(status);
    }

    @Override
    public void removeBook(Book book) {
        books.remove(book);
    }
}
