package com.marcos.biblioteca.repository;

import com.marcos.biblioteca.model.Book;
import com.marcos.biblioteca.model.ReadingStatus;
import com.marcos.biblioteca.storage.FileStorage;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class FileBookRepository implements BookRepository {
    List<Book> books;
    FileStorage fileStorage;

    public FileBookRepository(FileStorage fileStorage) throws IOException {
        this.fileStorage = fileStorage;
        books = fileStorage.loadBooksData();
    }

    @Override
    public void addBook(Book book){
        books.add(book);
        try {
            fileStorage.saveBookData(books);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Book> listBooks() {
        return Collections.unmodifiableList(books);
    }

    @Override
    public void updateStatus(Book book, ReadingStatus status) {
        book.setStatus(status);
        try {
            fileStorage.saveBookData(books);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeBook(Book book){
        books.remove(book);
        try {
            fileStorage.saveBookData(books);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
