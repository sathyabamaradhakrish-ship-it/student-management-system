package student_management_system;
 public class student extends person {
        private int id;
        private String course;
        public student(int id, String name, int age, String course) {
            super(name, age);
            this.id = id;
            this.course = course;
        }
        public int getId() {
            return id;
        }
        public String getCourse() {
            return course;
        }
        public void setId(int id) {
            this.id = id;
        }
        public void setName(String name) {
            this.name = name;
        }
        public void setAge(int age) {
            this.age = age;
        }
        public void setCourse(String course) {
            this.course = course;
        }
    }

