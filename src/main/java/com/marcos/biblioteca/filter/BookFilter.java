package com.marcos.biblioteca.filter;

import com.marcos.biblioteca.model.Book;

import java.util.List;

public interface BookFilter {
    List<Book> filter(List<Book> books);

}
