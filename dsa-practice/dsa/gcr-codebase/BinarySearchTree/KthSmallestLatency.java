import java.util.Stack;

public class KthSmallestLatency {

    static class LatencyNode {

        int val;
        LatencyNode left;
        LatencyNode right;

        LatencyNode(int val) {
            this.val = val;
        }
    }

    // Insert into BST
    static LatencyNode insert(LatencyNode root, int val) {

        if (root == null) {
            return new LatencyNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Find Kth Smallest
    static int kthSmallest(LatencyNode root, int k) {

        Stack<LatencyNode> stack = new Stack<>();

        LatencyNode current = root;
        int count = 0;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            count++;

            if (count == k) {
                return current.val;
            }

            current = current.right;
        }

        return -1;
    }

    public static void main(String[] args) {

        LatencyNode root = null;

        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 70);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 60);
        root = insert(root, 80);

        int k = 3;

        System.out.println(k + "rd Smallest Element = " + kthSmallest(root, k));
    }
}