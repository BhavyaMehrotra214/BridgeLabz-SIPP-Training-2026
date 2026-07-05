import java.util.*;

public class EventEntryVerificationSystem {

    static HashSet<String> participants = new HashSet<>();

    public static void registerParticipant(String email) {
        if (participants.add(email))
            System.out.println("Registration Successful");
        else
            System.out.println("Duplicate Registration Rejected");
    }

    public static void displayParticipants() {
        System.out.println("\nRegistered Participants:");
        for (String email : participants)
            System.out.println(email);

        System.out.println("Total Attendees: " + participants.size());
    }

    public static void main(String[] args) {
        registerParticipant("user1@gmail.com");
        registerParticipant("user2@gmail.com");
        registerParticipant("user1@gmail.com");

        displayParticipants();
    }
}