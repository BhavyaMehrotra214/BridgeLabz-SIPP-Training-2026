class Person {
    String name;
    int age;
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }
}

class Student extends Person {
    final String studentId;
    double gpa;

    Student(String name, int age, String studentId, double gpa) {
        super(name, age);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public String toString() {
        return super.toString() +
                ", Student ID: " + studentId +
                ", GPA: " + gpa;
    }
}

class GradStudent extends Student {
    String thesis;

    GradStudent(String name, int age, String studentId,
                double gpa, String thesis) {

        super(name, age, studentId, gpa);
        this.thesis = thesis;
    }

    public String toString() {
        return super.toString() +
                ", Thesis: " + thesis;
    }
}

public class UniversityDemo {
    public static void main(String[] args) {

        GradStudent g =
                new GradStudent("Palak",21,
                        "CS101",8.9,
                        "Artificial Intelligence");

        System.out.println(g);

        System.out.println("\nIS-A Relationship");
        System.out.println(g instanceof Student);
        System.out.println(g instanceof Person);
    }
}