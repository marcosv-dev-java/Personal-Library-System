package com.marcos.biblioteca.report;
import com.marcos.biblioteca.model.Book;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ReportGenerator {
     void generateReport(Map<String, List<Book>> books);
}
