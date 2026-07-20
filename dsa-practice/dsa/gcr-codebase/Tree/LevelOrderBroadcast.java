import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBroadcast {

    static class EmployeeNode {

        int val;
        EmployeeNode left;
        EmployeeNode right;

        EmployeeNode(int val) {
            this.val = val;
        }
    }

    // Insert into BST
    static EmployeeNode insert(EmployeeNode root, int val) {

        if (root == null) {
            return new EmployeeNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Level Order Traversal
    static List<List<Integer>> broadcastByLevel(EmployeeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<EmployeeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {

                EmployeeNode node = queue.poll();

                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            result.add(level);
        }

        return result;
    }

    public static void main(String[] args) {

        EmployeeNode root = null;

        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 70);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 60);
        root = insert(root, 80);

        System.out.println("Level Order Traversal:");

        List<List<Integer>> levels = broadcastByLevel(root);

        for (List<Integer> level : levels) {
            System.out.println(level);
        }
    }
}