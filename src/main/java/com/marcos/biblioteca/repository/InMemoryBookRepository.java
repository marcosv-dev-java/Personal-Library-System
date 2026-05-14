package com.marcos.biblioteca.repository;

import com.marcos.biblioteca.model.Book;
import com.marcos.biblioteca.model.ReadingStatus;

import java.util.ArrayList;
import java.util.List;

public class InMemoryBookRepository implements BookRepository {
    private List<Book> books;

    public InMemoryBookRepository() {
        this.books = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        if (this.books.contains(book)) {
        }
    }

    @Override
    public List<Book> listBooks() {
        return List.of();
    }

    @Override
    public void updateStatus(Book book, ReadingStatus status) {

    }

    @Override
    public void removeBook(Book book) {

    }
}
