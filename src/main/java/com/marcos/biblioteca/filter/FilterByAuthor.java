package com.marcos.biblioteca.filter;
import com.marcos.biblioteca.model.Book;
import java.util.ArrayList;
import java.util.List;

public class FilterByAuthor implements BookFilter {
    private final String author;

    public FilterByAuthor(String author) {
        this.author = author;
    }

    @Override
    public List<Book> filter(List<Book> books) {
        List<Book> filteredBooks = new ArrayList<>();
        for(Book book : books){
            if(author.equalsIgnoreCase(book.getAuthor())){
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }
}
