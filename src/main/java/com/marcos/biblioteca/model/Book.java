package com.marcos.biblioteca.model;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Book book)) return false;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(category, book.category) && status == book.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, category, status);
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", category='" + category + '\'' +
                ", status=" + status +
                '}';
    }
}
