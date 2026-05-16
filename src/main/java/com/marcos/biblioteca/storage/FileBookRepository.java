package com.marcos.biblioteca.storage;

import com.marcos.biblioteca.model.Book;
import com.marcos.biblioteca.model.ReadingStatus;
import com.marcos.biblioteca.repository.BookRepository;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileBookRepository implements BookRepository {
    final private BookRepository bookRepository;

    @Override
    public void addBook(Book book) {

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



    public FileBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }



}
