import java.util.*;

public class SmartClassroomAttendanceTracker {

    static HashMap<String, ArrayList<String>> attendance = new HashMap<>();

    public static void markAttendance(String subject, String student) {

        attendance.putIfAbsent(subject, new ArrayList<>());

        ArrayList<String> students = attendance.get(subject);

        if (!students.contains(student)) {
            students.add(student);
            System.out.println(student + " marked present in " + subject);
        } else {
            System.out.println("Duplicate attendance not allowed.");
        }
    }

    public static void displayAttendance() {

        for (String subject : attendance.keySet()) {

            System.out.println("\nSubject: " + subject);

            ArrayList<String> students = attendance.get(subject);

            for (String student : students)
                System.out.println(student);

            System.out.println("Total Present: " + students.size());
        }
    }

    public static void main(String[] args) {

        markAttendance("Java", "Ragini");
        markAttendance("Java", "Aman");
        markAttendance("Java", "Ragini");

        markAttendance("Python", "Riya");

        displayAttendance();
    }
}