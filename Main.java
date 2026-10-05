package student_management_system;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<student> students = new ArrayList<>();

        FileHandler.load(students);

        int choice;

        do {

            System.out.println("\n STUDENT MANAGEMENT SYSTEM ");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent(students, sc);
                    break;

                case 2:
                    viewStudents(students);
                    break;

                case 3:
                    updateStudent(students, sc);
                    break;

                case 4:
                    deleteStudent(students, sc);
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


    public static void addStudent(ArrayList<student> students, Scanner sc) {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Student Course: ");
        String course = sc.nextLine();

        student student = new student(id, name, age, course);

        students.add(student);

        FileHandler.save(students);

        System.out.println("Student added successfully!");
    }


    public static void viewStudents(ArrayList<student> students) {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\nStudent Records ");

        for (student s : students) {

            System.out.println("Student ID: " + s.getId());
            System.out.println("Student Name: " + s.getName());
            System.out.println("Student Age: " + s.getAge());
            System.out.println("Student Course: " + s.getCourse());
            System.out.println("____next____");

        }
    }


    public static void updateStudent(ArrayList<student> students, Scanner sc) {

        System.out.print("Enter Student ID to update: ");
        int updateId = sc.nextInt();
        sc.nextLine();

        boolean found = false;

        for (student s : students) {

            if (s.getId() == updateId) {

                System.out.print("Enter New Name: ");
                String newName = sc.nextLine();

                System.out.print("Enter New Age: ");
                int newAge = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Course: ");
                String newCourse = sc.nextLine();

                s.setName(newName);
                s.setAge(newAge);
                s.setCourse(newCourse);

                FileHandler.save(students);

                System.out.println("Student updated successfully!");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }


    public static void deleteStudent(ArrayList<student> students, Scanner sc) {

        System.out.print("Enter Student ID to delete: ");
        int deleteId = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getId() == deleteId) {

                students.remove(i);

                FileHandler.save(students);

                System.out.println("Student deleted successfully!");

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }
}

