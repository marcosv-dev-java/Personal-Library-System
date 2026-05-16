package com.marcos.biblioteca.storage;

import com.marcos.biblioteca.model.Book;
import com.marcos.biblioteca.model.ReadingStatus;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class FileStorage {
    final private String FILE_ADDRESS = "books.csv";

    public void saveBookData(List<Book> booksData) throws IOException {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_ADDRESS,StandardCharsets.UTF_8))) {
            StringBuilder stringBuilder = new StringBuilder();
            // The book data will be saved in this order : Title, Author, Category, Status
            for (Book book : booksData) {
                stringBuilder.append(book.getTitle());
                stringBuilder.append(",");
                stringBuilder.append(book.getAuthor());
                stringBuilder.append(",");
                stringBuilder.append(book.getCategory());
                stringBuilder.append(",");
                stringBuilder.append(book.getStatus());
                bw.write(stringBuilder.toString());
                bw.newLine();
                stringBuilder.setLength(0);
            }
        }
    }
    public List<Book> loadBooksData()throws IOException {
        List<Book> data = new ArrayList<>();
        File file = new File(FILE_ADDRESS);
        if(!file.exists()) return data;
        try(BufferedReader br = new BufferedReader(new FileReader(FILE_ADDRESS,StandardCharsets.UTF_8))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] bookData = line.split(",");
                String title = bookData[0];
                String author = bookData[1];
                String category = bookData[2];
                ReadingStatus status = ReadingStatus.valueOf(bookData[3]);
                Book currentBook = new Book(title, author, category, status);
                data.add(currentBook);
            }
            return data;

        }
    }
}
