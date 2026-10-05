package student_management_system;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


public class FileHandler {

    public static void save(ArrayList<student> students) {

        try {

            FileWriter writer = new FileWriter("students.txt");

            for (student s : students) {

                writer.write(
                        s.getId() + "," +
                                s.getName() + "," +
                                s.getAge() + "," +
                                s.getCourse() + "\n"
                );
            }

            writer.close();

        } catch (IOException e) {

            System.out.println("Error while saving file.");
        }
    }

    // Load student records
    public static void load(ArrayList<student> students) {

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader("students.txt"));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String course = data[3];

                student student =
                        new student(id, name, age, course);

                students.add(student);
            }

            reader.close();

        } catch (IOException e) {
        }
    }
}
