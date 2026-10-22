package student_management_system;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<student> students = new ArrayList<>();

        FileHandler.load(students);

        int choice = 0;

        do {

            System.out.println("\n STUDENT MANAGEMENT SYSTEM ");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");


            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number!");
                continue;
            }

            switch (choice) {

                case 1:
                    studentmanager.addStudent(students, sc);
                    break;

                case 2:
                    studentmanager.viewStudents(students);
                    break;

                case 3:
                    studentmanager.updateStudent(students, sc);
                    break;

                case 4:
                    studentmanager.deleteStudent(students, sc);
                    break;

                case 5:
                    System.out.println("-- Exit --");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}