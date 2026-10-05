package student_management_system;

public class person {
    protected String name;
        protected int age;

        // Constructor
        public person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Getter  Name
        public String getName() {
            return name;
        }

        // Getter Age
        public int getAge() {
            return age;
        }
    }

