import java.util.*;
class Patient {
    String name;
    int severity;

    Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }
}
public class EmergencyRoomTriageQueue {

    PriorityQueue<Patient> triageQueue = new PriorityQueue<>((a, b) -> b.severity - a.severity);

    public void addPatient(Patient p) {
        triageQueue.offer(p);
    }

    public Patient treatNext() {
        return triageQueue.poll();
    }

    public static void main(String[] args) {

        EmergencyRoomTriageQueue hospital = new EmergencyRoomTriageQueue();

        hospital.addPatient(new Patient("Amit", 3));
        hospital.addPatient(new Patient("Rahul", 8));
        hospital.addPatient(new Patient("Neha", 5));

        while (!hospital.triageQueue.isEmpty()) {
            Patient p = hospital.treatNext();
            System.out.println(p.name + " " + p.severity);
        }
    }
}