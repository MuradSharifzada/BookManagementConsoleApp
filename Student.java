//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String surname;
    private List<Book> borrowedBooks;

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.borrowedBooks = new ArrayList();
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public List<Book> getBorrowedBooks() {
        return this.borrowedBooks;
    }

    public void borrowBook(Book book) {
        book.setBorrowed(true);
        this.borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        book.setBorrowed(false);
        this.borrowedBooks.remove(book);
    }

    public String toString() {
        return this.name + " " + this.surname;
    }
}