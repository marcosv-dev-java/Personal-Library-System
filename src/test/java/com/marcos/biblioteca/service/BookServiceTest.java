package com.marcos.biblioteca.service;

import com.marcos.biblioteca.model.Book;
import com.marcos.biblioteca.model.ReadingStatus;
import com.marcos.biblioteca.repository.InMemoryBookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookServiceTest {
    BookService service;

    @BeforeEach
    void setUp() {
         service = new BookService(new InMemoryBookRepository());
    }

    @Test
    void cannotJumpFromWantingToRead_toRead() {
        Book book = new Book("Title", "Author", "Category", ReadingStatus.I_WANT_TO_READ);
        service.addBook(book);
        Assertions.assertThrows(IllegalArgumentException.class, ()->
                service.updateStatus(book, ReadingStatus.READ));

    }
    @Test
    void cannotGoBackToWantingToRead_whenStatusIsRead() {
        Book book = new Book("Title", "Author", "Category", ReadingStatus.READ);
        service.addBook(book);
        Assertions.assertThrows(IllegalArgumentException.class, ()->
                service.updateStatus(book, ReadingStatus.I_WANT_TO_READ));
    }
    @Test
    void cannotGoBackToReading_whenStatusIsRead() {
        Book book = new Book("Title", "Author", "Category", ReadingStatus.READ);
        service.addBook(book);

        Assertions.assertThrows(IllegalArgumentException.class,
                ()->
                service.updateStatus(book, ReadingStatus.READING));
    }
}
