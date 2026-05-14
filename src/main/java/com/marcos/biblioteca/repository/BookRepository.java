package com.marcos.biblioteca.repository;

import com.marcos.biblioteca.model.Book;
import com.marcos.biblioteca.model.ReadingStatus;
import java.util.List;
public interface BookRepository {

     void addBook(Book book);

     List<Book> listBooks();

     void updateStatus(Book book, ReadingStatus status);

     void removeBook(Book book);




}
