package com.marcos.biblioteca.ui;
import com.marcos.biblioteca.filter.BookFilter;
import com.marcos.biblioteca.model.Book;
import com.marcos.biblioteca.model.ReadingStatus;
import com.marcos.biblioteca.report.ReportGenerator;
import com.marcos.biblioteca.repository.FileBookRepository;
import com.marcos.biblioteca.service.BookService;
import com.marcos.biblioteca.service.ReportService;
import com.marcos.biblioteca.storage.FileStorage;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        final FileStorage storage = new FileStorage();
        final FileBookRepository repository = new FileBookRepository(storage);
        final BookService SERVICE = new BookService(repository);
        final ReportService reportService = new ReportService(repository);
        BookFilter filter;
        Menu menu = new Menu();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();
        name = menu.capitalize(name);
        System.out.println("========== Welcome " + name + " to your personal library ==========");
        while (true){
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
                System.out.print("Well done " + name + ", enter here your book title: ");
                String bookName = sc.nextLine();
                System.out.print(bookName + " ok, so who is the author of this book?");
                String bookAuthor = sc.nextLine();
                System.out.print("What category is this book in?");
                String bookCategory = sc.nextLine();
                boolean isValidInput = false;
                ReadingStatus status = null;
                while (!isValidInput) {
                    System.out.println("""
                            So.. type
                            1 if you already read this book
                            2 if you want to read
                            3 if you are reading""");
                    try {
                        choice = sc.nextInt();
                        if (choice == 1) status = ReadingStatus.READ;
                        else if (choice == 2) status = ReadingStatus.I_WANT_TO_READ;
                        else if (choice == 3) status = ReadingStatus.READING;
                        else throw new InputMismatchException();
                        isValidInput = true;
                    } catch (InputMismatchException e) {
                        System.out.println("\033[1;31mMann, just type a number!\033[m");
                        sc.nextLine();
                    }
                }

                Book book = new Book(bookName,bookAuthor,bookCategory, status);
                System.out.println(book.toString());


            }
            if (choice == 7) {
                break;
            }
        }




    }}


