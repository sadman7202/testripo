package lms;

import AbidProject.Book;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private String id;
    private static List<AbidProject.Book> borrowedBooks;

    public Member(String name, String id) {
        this.name = name;
        this.id = id;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters and setters

    public void borrowBook(AbidProject.Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(AbidProject.Book book) {
        borrowedBooks.remove(book);
    }
    public String getName(){
        return name;
    }
    public String getId(){
        return id;
    }
    public List<AbidProject.Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    public static void AddBooks(Book book){
        borrowedBooks.add(book);
    }


}
