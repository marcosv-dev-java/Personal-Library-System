package com.marcos.biblioteca.ui;

import com.marcos.biblioteca.filter.*;
import com.marcos.biblioteca.model.Book;
import com.marcos.biblioteca.model.ReadingStatus;
import com.marcos.biblioteca.service.BookService;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public String capitalize(String text) {
        if (text == null || text.isEmpty()) {
            return text;
        }
        return text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase();
    }
    public void formatedBook(Book book) {
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Category: " + book.getCategory());
        System.out.println("Status: " + book.getStatus());
    }
    public Book searchAndSelectBook(BookService service, Scanner sc){
        System.out.println("To find which book you want to update status, you need to filter the book list.");
        BookFilter filter = null;
        Book bookWanted = null;
        boolean isValidInput = false;
        List<Book> bookList = service.listBooks();
        List<Book> filteredList = null;
        while (!isValidInput) {
            System.out.print("""
                    1 - Filter by Author
                    2 - Filter by Category
                    3 - Filter by Status
                    4 - Filter by Title(recommended)
                    Type here:""");
            try {
                int filterChoice = sc.nextInt();
                sc.nextLine();
                if (filterChoice == 1) {
                    System.out.println("Author name: ");
                    String author = sc.nextLine();
                    filter = new FilterByAuthor(author);
                } else if (filterChoice == 2) {
                    System.out.println("Category name: ");
                    String category = sc.nextLine();
                    filter = new FilterByCategory(category);
                } else if (filterChoice == 3) {
                    ReadingStatus status;
                    System.out.print("""
                            Status
                            1 - Read
                            2 - Want to read
                            3 - Reading
                            Type here:""");
                    int statusChoice = sc.nextInt();
                    if (statusChoice == 1) status = ReadingStatus.READ;
                    else if (statusChoice == 2) status = ReadingStatus.I_WANT_TO_READ;
                    else if (statusChoice == 3) status = ReadingStatus.READING;
                    else throw new InputMismatchException();
                    filter = new FilterByStatus(status);
                } else if (filterChoice == 4) {
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    filter = new FilterByTitle(title);
                } else throw new InputMismatchException();

                filteredList = filter.filter(bookList);
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.println("\033[1;31mType a correct number!\033[m");
                sc.nextLine();
            }
            assert filteredList != null;
            if (!filteredList.isEmpty() && filteredList != null) {
                System.out.println("Type 1 when is the book you want");
                int bookNumber = 0;
                for (Book book : filteredList) {
                    formatedBook(book);
                    try {
                        bookNumber = sc.nextInt();
                        sc.nextLine();
                    }catch (InputMismatchException e){
                        System.out.println("\033[1;31mOnly type numbers![m");
                    }

                    if (bookNumber == 1) {
                        bookWanted = book;
                        break;
                    }
                }
            }
        }
        return  bookWanted;

    }
    public void registerBook(Scanner sc, String name, BookService service){
        System.out.print("Well done " + name + ", enter here your book title: ");
        String bookName = sc.nextLine();
        System.out.print(bookName + " ok, so who is the author of this book?");
        String bookAuthor = sc.nextLine();
        System.out.print("What category is this book in?");
        String bookCategory = sc.nextLine();
        ReadingStatus status = null;
        boolean isValidInput = false;
        while (!isValidInput) {
            System.out.println("""
                            So.. type
                            1 if you already read this book
                            2 if you want to read
                            3 if you are reading""");
            try {
                int choice = sc.nextInt();
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
        service.addBook(book);
    }
}
