import java.util.ArrayDeque;
import java.util.Deque;

class PrintQueue {

    Deque<Integer> printQueue;

    // Constructor
    PrintQueue() {
        printQueue = new ArrayDeque<>();
    }

    // Add Normal Job
    void submitJob(int jobId) {
        printQueue.addLast(jobId);
    }

    // Add Urgent Job
    void submitUrgentJob(int jobId) {
        printQueue.addFirst(jobId);
    }

    // Print Next Job
    int printNextJob() {

        if (printQueue.isEmpty()) {
            System.out.println("No Print Jobs");
            return -1;
        }

        return printQueue.removeFirst();
    }

    // Peek Front Job
    int peekJob() {

        if (printQueue.isEmpty()) {
            return -1;
        }

        return printQueue.peekFirst();
    }

    // Display Queue
    void display() {

        if (printQueue.isEmpty()) {
            System.out.println("Print Queue is Empty");
            return;
        }

        System.out.print("Print Queue: ");

        for (int job : printQueue) {
            System.out.print(job + " ");
        }

        System.out.println();
    }

    // Main Method
    public static void main(String[] args) {

        PrintQueue pq = new PrintQueue();

        pq.submitJob(101);
        pq.submitJob(102);
        pq.submitJob(103);

        pq.display();

        pq.submitUrgentJob(999);

        pq.display();

        System.out.println("Printing Job: " + pq.printNextJob());

        pq.display();

        System.out.println("Next Job: " + pq.peekJob());
    }
}