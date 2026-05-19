package com.marcos.biblioteca.service;

import com.marcos.biblioteca.model.Book;
import com.marcos.biblioteca.report.ReportGenerator;
import com.marcos.biblioteca.repository.BookRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportService{
    private final BookRepository repository;

    public ReportService(BookRepository repository) {
        this.repository = repository;

    }

    public Map<String, List<Book>> groupByCategory(){
        Map<String, List<Book>> map = new HashMap<>();
        List<Book> books = repository.listBooks();
        for(Book book : books){
            map.computeIfAbsent(book.getCategory(), k -> new ArrayList<>()).add(book);
        }


        return map;
    }


}
