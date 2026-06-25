class PP {
    protected String name;
    protected int age;

    public PP(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                ", Age: " + age;
    }
}

class UGStudent extends PP {
    protected final int studentId;
    protected double gpa;

    public UGStudent(String name, int age,
                     int studentId, double gpa) {
        super(name, age);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Student ID: " + studentId +
                ", GPA: " + gpa;
    }
}

class PGStudent extends UGStudent {
    private String thesis;

    public PGStudent(String name, int age,
                     int studentId, double gpa,
                     String thesis) {
        super(name, age, studentId, gpa);
        this.thesis = thesis;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Thesis: " + thesis;
    }
}

public class University {
    public static void main(String[] args) {

        PGStudent pg = new PGStudent(
                "Bhavya", 22, 101,
                8.9, "AI in Education");

        System.out.println(pg);

        // IS-A Relationship
        UGStudent ug = pg; // PGStudent IS-A UGStudent
        PP p = pg;         // PGStudent IS-A PP

        System.out.println("\nUsing UGStudent Reference:");
        System.out.println(ug);

        System.out.println("\nUsing PP Reference:");
        System.out.println(p);
    }
}