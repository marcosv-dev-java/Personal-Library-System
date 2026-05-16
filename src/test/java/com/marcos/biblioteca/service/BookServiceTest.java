
package com.marcos.biblioteca.service;

import com.marcos.biblioteca.model.Book;
import com.marcos.biblioteca.model.ReadingStatus;
import com.marcos.biblioteca.repository.InMemoryBookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookServiceTest {
    BookService service;
    Book book;

    @BeforeEach
    void setUp() {
         service = new BookService(new InMemoryBookRepository());
         book = new Book("Title", "Author", "Category", ReadingStatus.READ);
    }
    @Test
    void addBookThatAlreadyExists_shouldThrowException() {
        service.addBook(book);
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.addBook(book);
        });
        Assertions.assertEquals("Book already exists", exception.getMessage());

    }
    @Test
    void updateBookStatusWhichTheSameStatus(){
        service.addBook(book);
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            service.updateStatus(book, ReadingStatus.READ);
        });
        Assertions.assertEquals("The book already have this status!", exception.getMessage());
    }
    @Test
    void updateBookStatusWhoDoesNotExist(){
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
            service.updateStatus(book, ReadingStatus.READING)
        );
        Assertions.assertEquals("Book does not exist", exception.getMessage());
    }

    @Test
    void cannotJumpFromWantingToRead_toRead() {
        Book book = new Book("Title", "Author", "Category", ReadingStatus.I_WANT_TO_READ);
        service.addBook(book);
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, ()->
                service.updateStatus(book, ReadingStatus.READ));
        Assertions.assertEquals("Can't jump from 'I_WANT_TO_READ' to 'READ'!", exception.getMessage());
    }
    @Test
    void cannotGoBackToWantingToRead_whenStatusIsRead() {
        service.addBook(book);
        IllegalArgumentException exception =Assertions.assertThrows(IllegalArgumentException.class, ()->
                service.updateStatus(book, ReadingStatus.I_WANT_TO_READ));
        Assertions.assertEquals("Can't go back, you already read this!", exception.getMessage());
    }
    @Test
    void cannotGoBackToReading_whenStatusIsRead() {
        service.addBook(book);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                ()->
                service.updateStatus(book, ReadingStatus.READING));
    Assertions.assertEquals("Can't go back, you already read this!", exception.getMessage());
    }
    @Test
    void removingBookThatDoesNotExist_shouldThrowException() {
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, ()->
                service.removeBook(book));
        Assertions.assertEquals("Book does not exist", exception.getMessage());
    }




}
