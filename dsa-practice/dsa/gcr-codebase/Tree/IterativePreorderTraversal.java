import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativePreorderTraversal {

    static class OrgNode {

        int val;
        OrgNode left;
        OrgNode right;

        OrgNode(int val) {
            this.val = val;
        }
    }

    // Insert into BST
    static OrgNode insert(OrgNode root, int val) {

        if (root == null) {
            return new OrgNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Iterative Preorder Traversal
    static List<Integer> iterativePreorder(OrgNode root) {

        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Stack<OrgNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            OrgNode node = stack.pop();

            result.add(node.val);

            if (node.right != null) {
                stack.push(node.right);
            }

            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        OrgNode root = null;

        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 70);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 60);
        root = insert(root, 80);

        System.out.println("Preorder Traversal:");
        System.out.println(iterativePreorder(root));
    }
}