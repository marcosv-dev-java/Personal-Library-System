package com.marcos.biblioteca.repository;

import com.marcos.biblioteca.model.Book;
import com.marcos.biblioteca.model.ReadingStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BookRepositoryTest {
    InMemoryBookRepository inMemoryBookRepository;


    @BeforeEach
    void setUp() {
         inMemoryBookRepository = new InMemoryBookRepository();
    }

    @Test
    void shouldAdd_a_Book(){
        Book bookNormal = new Book("Title", "Author", "Category", ReadingStatus.READ);
        inMemoryBookRepository.addBook(bookNormal);
        Assertions.assertEquals(bookNormal, inMemoryBookRepository.listBooks().getFirst());

    }
    @Test
    void addingBookThatAlreadyExist(){
        Book book = new Book("Title", "Author", "Category", ReadingStatus.READ);
        inMemoryBookRepository.addBook(book);

        Assertions.assertThrows(IllegalArgumentException.class, ()->
            inMemoryBookRepository.addBook(book));
    }

    @Test
    void emptyListTest(){
        List<Book> books = inMemoryBookRepository.listBooks();
        Assertions.assertTrue(books.isEmpty());
    }
    @Test
    void listWithBooksTest(){
        inMemoryBookRepository.addBook(new Book("Title", "Author", "Category", ReadingStatus.READ));
        inMemoryBookRepository.addBook(new Book("Title2", "Author", "Category", ReadingStatus.READ));
        inMemoryBookRepository.addBook(new Book("Title3", "Author", "Category", ReadingStatus.READ));
        List<Book> books = inMemoryBookRepository.listBooks();
        Assertions.assertEquals(3, books.size());
    }
    @Test
    void listBooks_shouldBeUnmodifiable(){
        Assertions.assertThrows(UnsupportedOperationException.class, ()->{
            inMemoryBookRepository.listBooks().add(new Book("Title", "Author", "Category", ReadingStatus.READ));
        });
    }
    @Test
    void shouldUpdateBookStatus(){
        Book book = new Book("Title", "Author", "Category", ReadingStatus.READING);
        inMemoryBookRepository.addBook(book);
        inMemoryBookRepository.updateStatus(book, ReadingStatus.READ);
        Assertions.assertEquals(ReadingStatus.READ, inMemoryBookRepository.listBooks().getFirst().getStatus());
    }
    @Test
    void updateBookStatusWithTheSameStatus_shouldThrowException(){
        Book book = new Book("Title", "Author", "Category", ReadingStatus.READ);
        inMemoryBookRepository.addBook(book);
        Assertions.assertThrows(IllegalArgumentException.class, ()->
            inMemoryBookRepository.updateStatus(book, ReadingStatus.READ)
        );

    }
    @Test
    void updateBookStatusWhoDoenstExist_shouldThrowException(){
        Book book = new Book("Title", "Author", "Category", ReadingStatus.READ);

        Assertions.assertThrows(IllegalArgumentException.class, ()->
                inMemoryBookRepository.updateStatus(book, ReadingStatus.I_WANT_TO_READ)
                );

    }
    @Test
    void shouldRemoveBook(){
        Book book = new Book("Title", "Author", "Category", ReadingStatus.READ);
        inMemoryBookRepository.addBook(book);
        inMemoryBookRepository.removeBook(book);
        Assertions.assertEquals(0 , inMemoryBookRepository.listBooks().size());
    }
    @Test
    void remove_a_bookWhoDoenstExist_shouldThrowException(){
        Book book = new Book("Title", "Author", "Category", ReadingStatus.READ);
        Assertions.assertThrows(IllegalArgumentException.class, ()->
                inMemoryBookRepository.removeBook(book));
    }

}
