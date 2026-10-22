package student_management_system;

public class person {

    protected String name;
    protected int age;

    public person(String name, int age) {
        setName(name);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.contains(",")) {
            throw new IllegalArgumentException(
                    "Name cannot be empty or contain comma"
            );
        }
        this.name = name.trim();
    }

    public void setAge(int age) {
        if (age <= 0) {
            throw new IllegalArgumentException(
                    "Age must be greater than zero"
            );
        }
        this.age = age;
    }
}