package com.marcos.biblioteca.service;

import com.marcos.biblioteca.model.Book;
import com.marcos.biblioteca.model.ReadingStatus;
import com.marcos.biblioteca.repository.InMemoryBookRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;


public class ReportServiceTest {
    ReportService service;
    InMemoryBookRepository repository;

    @BeforeEach
    void setUp() {
        repository = new InMemoryBookRepository();
         service = new ReportService(repository);

    }

    @Test
    void shouldGroupByCategory() {
        Book book1 = new Book("Linux Fundamentals","Linus Torvalds","Study", ReadingStatus.READING);
        Book book2 = new Book("Arch Linux Fundamentals","Linus Torvalds","Study", ReadingStatus.READING);
        Book book3 = new Book("Fedora Fundamentals","Linus Torvalds","Study", ReadingStatus.READING);
        Book book4 = new Book("Minecraft","Somebody","Game", ReadingStatus.READING);
        Book book5 = new Book("Roblox","A lazy dude","Game", ReadingStatus.READING);
        repository.addBook(book1);
        repository.addBook(book2);
        repository.addBook(book3);
        repository.addBook(book4);
        repository.addBook(book5);
        Map<String, List<Book>> groupByCategory = service.groupByCategory();

        // Verify if contains the key
        Assertions.assertTrue(groupByCategory.containsKey("Game"));
        Assertions.assertTrue(groupByCategory.containsKey("Study"));
        // Verify if the map is with the correct size
        Assertions.assertEquals(2, groupByCategory.size());
        // Verify the keys size
        Assertions.assertEquals(2, groupByCategory.get("Game").size());
        Assertions.assertEquals(3, groupByCategory.get("Study").size());


    }
}
