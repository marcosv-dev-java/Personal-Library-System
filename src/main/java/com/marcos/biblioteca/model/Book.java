package com.marcos.biblioteca.model;

public class Book {
    final private String title;
    final private String author;
    final private String category;
    private ReadingStatus status;

    public Book(String title, String author, String category, ReadingStatus status) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public ReadingStatus getStatus() {
        return status;
    }

    public void setStatus(ReadingStatus status) {
        this.status = status;
    }
}
