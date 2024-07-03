
import java.util.List;

public class StudentService {
    private List<Student> students;

    public StudentService(List<Student> students) {
        this.students = students;
    }

    public Student findStudentByName(String name, String surname) {
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name) && student.getSurname().equalsIgnoreCase(surname)) {
                return student;
            }
        }
        return null;
    }

    public void displayBorrowedBooks(Student student) {
        for (Book book : student.getBorrowedBooks()) {
            System.out.println(book);
        }
    }
}
