package com.marcos.biblioteca.report;
import com.marcos.biblioteca.model.Book;

import java.util.List;
import java.util.Map;

public interface ReportGenerator {
    public void generateReport(Map<String, List<Book>> books);
}
