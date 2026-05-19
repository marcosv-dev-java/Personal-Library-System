package com.marcos.biblioteca.ui;
import com.marcos.biblioteca.filter.BookFilter;
import com.marcos.biblioteca.model.Book;
import com.marcos.biblioteca.model.ReadingStatus;
import com.marcos.biblioteca.report.ReportCSV;
import com.marcos.biblioteca.repository.FileBookRepository;
import com.marcos.biblioteca.service.BookService;
import com.marcos.biblioteca.service.ReportService;
import com.marcos.biblioteca.storage.FileStorage;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        final FileStorage storage = new FileStorage();
        final ReportCSV reportCSV = new ReportCSV();
        final FileBookRepository repository = new FileBookRepository(storage);
        final BookService service = new BookService(repository);
        final ReportService reportService = new ReportService(repository);
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        name = menu.capitalize(name);
        System.out.println("========== Welcome " + name + " to your personal library ==========");
        while (true) {
            System.out.println("What do you want to do today? ");
            System.out.print("""
                    1 - Register a new book
                    2 - View the book list
                    3 - Update a book status
                    4 - Remove a book
                    5 - Generate report
                    6 - Filter the book list
                    7 - Exit
                    \033[1;35mEnter here you choice: \033[m""");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                menu.registerBook(sc, name, service);
            } else if (choice == 2) {
                List<Book> bookList = service.listBooks();
                for (Book book : bookList) {
                    menu.formatedBook(book);
                }
            } else if (choice == 3) {
                Book bookWanted = menu.searchAndSelectBook(service, sc);
                ReadingStatus status;
                if (bookWanted != null) {
                    System.out.println("Which status do you want to update? ");
                    status = menu.selectBookStatus(sc);
                    service.updateStatus(bookWanted, status);
                }
            } else if (choice == 4) {
                Book bookWanted = menu.searchAndSelectBook(service, sc);
                service.removeBook(bookWanted);
            } else if (choice == 5) {
                Map<String, List<Book>> report = reportService.groupByCategory();
                reportCSV.generateReport(report);
            } else if(choice == 6) {
                BookFilter filter = menu.selectBookFilter(sc);
                List<Book> filteredList = filter.filter(service.listBooks());
                for (Book book : filteredList) {
                    menu.formatedBook(book);
                }
            } else if (choice == 7) {
                break;
            }
        }
    }
}







