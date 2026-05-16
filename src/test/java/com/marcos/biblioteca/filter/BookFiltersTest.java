package com.marcos.biblioteca.filter;

import com.marcos.biblioteca.model.Book;
import com.marcos.biblioteca.model.ReadingStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BookFiltersTest {
    BookFilter bookFilter;
    List<Book> books;
    @BeforeEach
    void setUp() {
        books = new ArrayList<Book>();
        books.add(new Book("Title2", "Author", "Category", ReadingStatus.I_WANT_TO_READ));
        books.add(new Book("Title", "Author2", "Category3", ReadingStatus.READING));
        books.add(new Book("Title5", "Author2", "Category2", ReadingStatus.READING));
        books.add(new Book("Title2", "Author5", "Category2", ReadingStatus.READ));
    }


    @Test
    void shouldFilterByAuthor_ignoreCase() {
        bookFilter = new FilterByAuthor("author5");
        List<Book> filteredBooks = bookFilter.filter(books);
        Assertions.assertEquals(1, filteredBooks.size());
    }

    @Test
    void shouldFilterByCategory_ignoreCase() {
        bookFilter = new FilterByCategory("category3");
        List<Book> filteredBooks = bookFilter.filter(books);
        Assertions.assertEquals(1, filteredBooks.size());
    }
    @Test
    void shouldFilterByTitle_ignoreCase() {
        bookFilter = new FilterByTitle("title5");
        List<Book> filteredBooks = bookFilter.filter(books);
        Assertions.assertEquals(1, filteredBooks.size());
    }
    @Test
    void shouldFilterByReadingStatus() {
        bookFilter = new FilterByStatus(ReadingStatus.I_WANT_TO_READ);
        List<Book> filteredBooks = bookFilter.filter(books);
        Assertions.assertEquals(1, filteredBooks.size());
    }
}
