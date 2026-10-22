package student_management_system;
import java.util.ArrayList;
import java.util.Scanner;
public class studentmanager {
    public static void addStudent(ArrayList<student> students, Scanner sc) {

        try {
            System.out.print("Enter Student ID: ");
            int id = Integer.parseInt(sc.nextLine().trim());

            // Check duplicate ID
            for (student s : students) {
                if (s.getId() == id) {
                    System.out.println("Student ID already exists!");
                    return;
                }
            }

            System.out.print("Enter Student Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Student Age: ");
            int age = Integer.parseInt(sc.nextLine().trim());

            System.out.print("Enter Student Course: ");
            String course = sc.nextLine();

            student newStudent = new student(id, name, age, course);

            students.add(newStudent);
            FileHandler.save(students);

            System.out.println("Student added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! ID and age must be numbers.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }


    // View Students
    public static void viewStudents(ArrayList<student> students) {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\nStudent Records");

        for (student s : students) {
            System.out.println("Student ID: " + s.getId());
            System.out.println("Student Name: " + s.getName());
            System.out.println("Student Age: " + s.getAge());
            System.out.println("Student Course: " + s.getCourse());
            System.out.println("____next____");
        }
    }


    // Update Student
    public static void updateStudent(ArrayList<student> students, Scanner sc) {

        try {
            System.out.print("Enter Student ID to update: ");
            int updateId = Integer.parseInt(sc.nextLine().trim());

            boolean found = false;

            for (student s : students) {

                if (s.getId() == updateId) {

                    System.out.print("Enter New Name: ");
                    String newName = sc.nextLine();

                    System.out.print("Enter New Age: ");
                    int newAge = Integer.parseInt(sc.nextLine().trim());

                    System.out.print("Enter New Course: ");
                    String newCourse = sc.nextLine();

                    // Validate before changing existing details
                    student updatedStudent =
                            new student(updateId, newName, newAge, newCourse);

                    s.setName(updatedStudent.getName());
                    s.setAge(updatedStudent.getAge());
                    s.setCourse(updatedStudent.getCourse());

                    FileHandler.save(students);

                    System.out.println("Student updated successfully!");

                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("Student not found.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! ID and age must be numbers.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: " + e.getMessage());
        }
    }


    // Delete Student
    public static void deleteStudent(ArrayList<student> students, Scanner sc) {

        try {
            System.out.print("Enter Student ID to delete: ");
            int deleteId = Integer.parseInt(sc.nextLine().trim());

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

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Student ID must be a number.");
        }
    }
}
