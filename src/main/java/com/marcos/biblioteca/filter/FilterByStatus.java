package com.marcos.biblioteca.filter;

import com.marcos.biblioteca.model.Book;
import com.marcos.biblioteca.model.ReadingStatus;

import java.util.ArrayList;
import java.util.List;

public class FilterByStatus implements BookFilter{
    private final ReadingStatus readingStatus;

    public FilterByStatus(ReadingStatus readingStatus) {
        this.readingStatus = readingStatus;
    }

    @Override
    public List<Book> filter(List<Book> books) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : books) {
            if(book.getStatus().equals(readingStatus)){
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }
}
