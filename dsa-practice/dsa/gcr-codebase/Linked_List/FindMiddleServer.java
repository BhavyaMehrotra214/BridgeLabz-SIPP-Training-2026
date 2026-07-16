public class DetectRedirectLoop {

    // Node class
    static class Node {
        String url;
        Node next;

        Node(String url) {
            this.url = url;
            this.next = null;
        }
    }

    // Detect cycle using Floyd's Cycle Detection Algorithm
    public static boolean hasRedirectLoop(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        // Creating redirect chain
        Node url1 = new Node("A");
        Node url2 = new Node("B");
        Node url3 = new Node("C");
        Node url4 = new Node("D");

        url1.next = url2;
        url2.next = url3;
        url3.next = url4;

        // Create a redirect loop: D -> B
        url4.next = url2;

        if (hasRedirectLoop(url1)) {
            System.out.println("Redirect loop detected.");
        } else {
            System.out.println("No redirect loop found.");
        }
    }
}