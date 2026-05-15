package com.marcos.biblioteca.service;

import com.marcos.biblioteca.model.Book;
import com.marcos.biblioteca.model.ReadingStatus;
import com.marcos.biblioteca.repository.BookRepository;

import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {
        bookRepository.addBook(book);
    }

    public List<Book> listBooks() {
        return bookRepository.listBooks();
    }

    public void updateStatus(Book book, ReadingStatus status) {
        if (book.getStatus().equals(ReadingStatus.I_WANT_TO_READ) && status.equals(ReadingStatus.READ)){
            throw new IllegalArgumentException("Can't jump from 'I_WANT_TO_READ' to 'READ'!");
        }
        if (book.getStatus().equals(ReadingStatus.READ) && (status.equals(ReadingStatus.I_WANT_TO_READ) || status.equals(ReadingStatus.READING))){
            throw new IllegalArgumentException("Can't go back, you already read this!");
        }
        bookRepository.updateStatus(book, status);
    }

    public void removeBook(Book book) {
        bookRepository.removeBook(book);
    }
}
