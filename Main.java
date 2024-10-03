import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Main {
    public static void main(String[] args) {
    
        List<Book> books = new ArrayList<>();
        books.add(new Book("Introduction to Algorithms", "Thomas H.", "97", "Educational"));
        books.add(new Book("Atomic Habit", "James Clear", "978", "Test"));
        books.add(new Book("Why We Sleep", "Matthew Walker", "9780", "Test1"));
        List<Student> students = new ArrayList<>();
        students.add(new Student("Murad", "Sharifzada"));
        students.add(new Student("Bilal", "Sharifzada"));

        BookService bookService = new BookService(books);
        StudentService studentService = new StudentService(students);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Display Catalog");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. View Borrowed Books");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    bookService.displayCatalog();
                    break;
                case 2:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    List<Book> foundBooks = bookService.searchBooksByTitle(title);
                    if (foundBooks.isEmpty()) {
                        System.out.println("No books found with that title.");
                    } else {
                        System.out.print("Yes we have same book: ");
                        foundBooks.forEach(System.out::println);
                    }
                    break;
                case 3:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter your surname: ");
                    String surname = scanner.nextLine();
                    Student student = studentService.findStudentByName(name, surname);
                    if (student != null) {
                        System.out.print("Enter book title to borrow: ");
                        title = scanner.nextLine();
                        Book bookToBorrow = bookService.findBook
                        ByTitle(title);
                        if (bookToBorrow != null) {
                            student.borrowBook(bookToBorrow);
                            System.out.println("Book borrowed successfully.");
                        } else {
                            System.out.println("Book not available.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter your name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter your surname: ");
                    surname = scanner.nextLine();
                    student = studentService.findStudentByName(name, surname);
                    if (student != null) {
                        System.out.print("Enter book title to return: ");
                        title = scanner.nextLine();
                        Book bookToReturn = null;
                        for (Book book : student.getBorrowedBooks()) {
                            if (book.getTitle().equalsIgnoreCase(title)) {
                                bookToReturn = book;
                                break;
                            }
                        }
                        if (bookToReturn != null) {
                            student.returnBook(bookToReturn);
                            System.out.println("Book returned successfully.");
                        } else {
                            System.out.println("You have not borrowed this book.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter your name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter your surname: ");
                    surname = scanner.nextLine();
                    student = studentService.findStudentByName(name, surname);
                    if (student != null) {
                        System.out.println("Your borrowed books:");
                        studentService.displayBorrowedBooks(student);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
