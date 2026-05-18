package com.marcos.biblioteca.report;

import com.marcos.biblioteca.model.Book;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

public class ReportCSV implements ReportGenerator {
    @Override
    public void generateReport(Map<String, List<Book>> books) {
        String FILE_ADDRESS = "report.csv";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_ADDRESS, StandardCharsets.UTF_8))) {
            StringBuilder builder = new StringBuilder();
            for (Map.Entry<String, List<Book>> entry : books.entrySet()) {
                // Category, Title, Author, Status
                for (Book book : entry.getValue()) {
                    builder.append(entry.getKey());
                    builder.append(",");
                    builder.append(book.getTitle());
                    builder.append(",");
                    builder.append(book.getAuthor());
                    builder.append(",");
                    builder.append(book.getStatus());
                    bw.write(builder.toString());
                    bw.newLine();
                    builder.setLength(0);
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
