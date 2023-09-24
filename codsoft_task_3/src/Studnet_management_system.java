import java.util.ArrayList;
import java.util.List;

class Student {
    private String name;
    private int rollNumber;
    private char grade;

    public Student(String name, int rollNumber, char grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public char getGrade() {
        return grade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Roll Number: " + rollNumber + ", Grade: " + grade;
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                students.remove(student);
                break;
            }
        }
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

public class Studnet_management_system {
    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();

        Student student1 = new Student("Ali", 101, 'A');
        Student student2 = new Student("Babar", 102, 'B');
        Student student3 = new Student("Chahat", 103, 'C');

        system.addStudent(student1);
        system.addStudent(student2);
        system.addStudent(student3);

        System.out.println("All Students:");
        system.displayAllStudents();

        int searchRollNumber = 102;
        System.out.println("\nSearching for student with Roll Number " + searchRollNumber + ":");
        Student foundStudent = system.searchStudent(searchRollNumber);
        if (foundStudent != null) {
            System.out.println(foundStudent);
        } else {
            System.out.println("Student not found.");
        }

        int removeRollNumber = 101;
        System.out.println("\nRemoving student with Roll Number " + removeRollNumber + ":");
        system.removeStudent(removeRollNumber);
        System.out.println("Updated Student List:");
        system.displayAllStudents();
    }
}
