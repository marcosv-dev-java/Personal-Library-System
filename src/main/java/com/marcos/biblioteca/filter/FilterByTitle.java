package com.marcos.biblioteca.filter;

import com.marcos.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class FilterByTitle implements BookFilter {
    private final String title;

    public FilterByTitle(String title) {
        this.title = title;
    }

    @Override
    public List<Book> filter(List<Book> books) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books) {
            if(book.getTitle().equalsIgnoreCase(this.title)){
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }
}
