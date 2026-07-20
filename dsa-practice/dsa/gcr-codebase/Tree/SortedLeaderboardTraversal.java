import java.util.ArrayList;
import java.util.List;

public class SortedLeaderboardTraversal {

    static class ScoreNode {

        int val;
        ScoreNode left;
        ScoreNode right;

        ScoreNode(int val) {
            this.val = val;
        }
    }

    // Insert into BST
    static ScoreNode insert(ScoreNode root, int val) {

        if (root == null) {
            return new ScoreNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Recursive Inorder Traversal
    static void inorder(ScoreNode node, List<Integer> result) {

        if (node == null) {
            return;
        }

        inorder(node.left, result);
        result.add(node.val);
        inorder(node.right, result);
    }

    static List<Integer> getSortedLeaderboard(ScoreNode root) {

        List<Integer> result = new ArrayList<>();

        inorder(root, result);

        return result;
    }

    public static void main(String[] args) {

        ScoreNode root = null;

        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 70);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 60);
        root = insert(root, 80);

        System.out.println("Sorted Leaderboard:");
        System.out.println(getSortedLeaderboard(root));
    }
}