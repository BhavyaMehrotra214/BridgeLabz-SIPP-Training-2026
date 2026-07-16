public class InsertTrack_PlaylistQueue {

    // Node class
    static class Node {
        int trackId;
        Node next;

        Node(int trackId) {
            this.trackId = trackId;
            this.next = null;
        }
    }

    // Insert a new track after the current track
    public static void insertAfter(Node current, int trackId) {
        if (current == null) {
            return;
        }

        Node newNode = new Node(trackId);

        newNode.next = current.next;
        current.next = newNode;
    }

    // Display the playlist
    public static void display(Node head) {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.trackId + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        // Creating playlist: 101 -> 102 -> 104
        Node head = new Node(101);
        head.next = new Node(102);
        head.next.next = new Node(104);

        System.out.println("Original Playlist:");
        display(head);

        // Insert track 103 after track 102
        insertAfter(head.next, 103);

        System.out.println("Playlist After Insertion:");
        display(head);
    }
}