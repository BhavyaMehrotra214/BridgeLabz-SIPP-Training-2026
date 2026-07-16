import java.util.PriorityQueue;

class Patient {

    int priority;
    String name;

    Patient(int priority, String name) {
        this.priority = priority;
        this.name = name;
    }
}

class HospitalERTriage {

    PriorityQueue<Patient> triageQueue;

    // Constructor
    HospitalERTriage() {

        triageQueue = new PriorityQueue<>(
                (a, b) -> a.priority - b.priority
        );
    }

    // Admit Patient
    void admitPatient(Patient p) {
        triageQueue.offer(p);
    }

    // Call Next Patient
    Patient callNextPatient() {

        if (triageQueue.isEmpty()) {
            return null;
        }

        return triageQueue.poll();
    }

    // Peek Most Urgent Patient
    Patient peekPatient() {

        if (triageQueue.isEmpty()) {
            return null;
        }

        return triageQueue.peek();
    }

    // Display Patients
    void display() {

        if (triageQueue.isEmpty()) {
            System.out.println("No Patients Waiting");
            return;
        }

        System.out.println("Patients Waiting:");

        for (Patient p : triageQueue) {
            System.out.println(p.name + " (Priority " + p.priority + ")");
        }
    }

    // Main Method
    public static void main(String[] args) {

        HospitalERTriage hospital = new HospitalERTriage();

        hospital.admitPatient(new Patient(3, "Rahul"));
        hospital.admitPatient(new Patient(1, "Aman"));
        hospital.admitPatient(new Patient(5, "Priya"));
        hospital.admitPatient(new Patient(2, "Neha"));

        hospital.display();

        Patient p = hospital.callNextPatient();

        System.out.println("\nCalling Patient:");
        System.out.println(p.name + " (Priority " + p.priority + ")");

        Patient next = hospital.peekPatient();

        System.out.println("\nNext Patient:");
        System.out.println(next.name + " (Priority " + next.priority + ")");
    }
}