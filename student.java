
package student_management_system;

public class student extends person {

    private int id;
    private String course;

    public student(int id, String name, int age, String course) {
        super(name, age);
        setId(id);
        setCourse(course);
    }

    public int getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    public void setId(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException(
                    "Student ID must be greater than zero"
            );
        }
        this.id = id;
    }

    public void setName(String name) {
        super.setName(name);

    }

    public void setAge(int age) {
        super.setAge(age);
    }

    public void setCourse(String course) {
        if (course == null || course.trim().isEmpty()
                || course.contains(",")) {
            throw new IllegalArgumentException(
                    "Course cannot be empty or contain comma"
            );
        }
        this.course = course.trim();
    }
}
