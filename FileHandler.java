
package student_management_system;

import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FileHandler {

    // Save student records
    public static void save(ArrayList<student> students) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("students.txt"))) {

            for (student s : students) {

                writer.write(
                        s.getId() + "," +
                                s.getName() + "," +
                                s.getAge() + "," +
                                s.getCourse()
                );

                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error while saving file: " + e.getMessage());
        }
    }


    // Load student records
    public static void load(ArrayList<student> students) {

        Set<Integer> ids = new HashSet<>();

        try (BufferedReader reader =
                     new BufferedReader(new FileReader("students.txt"))) {

            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {

                lineNumber++;

                try {
                    String[] data = line.split(",", -1);

                    if (data.length != 4) {
                        throw new IllegalArgumentException(
                                "Incorrect record format"
                        );
                    }

                    int id = Integer.parseInt(data[0].trim());
                    String name = data[1].trim();
                    int age = Integer.parseInt(data[2].trim());
                    String course = data[3].trim();

                    if (ids.contains(id)) {
                        throw new IllegalArgumentException(
                                "Duplicate student ID"
                        );
                    }

                    student student =
                            new student(id, name, age, course);

                    students.add(student);
                    ids.add(id);

                } catch (IllegalArgumentException e) {

                    System.out.println(
                            "Skipping invalid record at line " +
                                    lineNumber + ": " + e.getMessage()
                    );
                }
            }

        } catch (IOException e) {

            if (!(e instanceof java.io.FileNotFoundException)) {
                System.out.println(
                        "Error while loading file: " + e.getMessage()
                );
            }
        }
    }
}
