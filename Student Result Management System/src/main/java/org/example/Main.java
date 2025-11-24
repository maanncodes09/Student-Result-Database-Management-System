import DatabaseManager.DatabaseManagement;
import Model.Student;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        DatabaseManagement DatabaseManager = new DatabaseManagement();

        while (true) {
            System.out.println("\n=== STUDENT MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student Course");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1 -> {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    Student s = new Student(id, name, course);
                    DatabaseManager.addStudent(s);
                }

                case 2 -> {
                    System.out.println("\n--- All Students ---");
                    for (Student s : DatabaseManager.getAllStudents()) {
                        System.out.println(s);
                    }
                }

                case 3 -> {
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();

                    DatabaseManager.updateCourse(id, newCourse);
                }

                case 4 -> {
                    System.out.print("Enter Student ID to delete: ");
                    int delId = sc.nextInt();
                    DatabaseManager.deleteStudent(delId);
                }

                case 5 -> {
                    System.out.println("Exiting...");
                    return;
                }

                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }
}