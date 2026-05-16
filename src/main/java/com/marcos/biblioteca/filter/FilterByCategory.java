package com.marcos.biblioteca.filter;

import com.marcos.biblioteca.model.Book;

import java.util.ArrayList;
import java.util.List;

public class FilterByCategory implements BookFilter {
    private final String category;

    public FilterByCategory(String category) {
        this.category = category;
    }

    @Override
    public List<Book> filter(List<Book> books) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }
}
