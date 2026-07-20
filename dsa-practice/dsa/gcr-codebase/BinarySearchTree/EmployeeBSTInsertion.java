
public class EmployeeBSTInsertion {

    static class EmployeeNode {

        int val;
        EmployeeNode left;
        EmployeeNode right;

        EmployeeNode(int val) {
            this.val = val;
        }
    }

    // Insert a new employee ID
    static EmployeeNode insert(EmployeeNode node, int id) {

        if (node == null) {
            return new EmployeeNode(id);
        }

        if (id < node.val) {
            node.left = insert(node.left, id);
        }
        else if (id > node.val) {
            node.right = insert(node.right, id);
        }

        return node;
    }

    // Inorder Traversal
    static void inorder(EmployeeNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
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

        // Insert new employee
        root = insert(root, 65);

        System.out.println("BST after inserting employee ID:");

        inorder(root);
    }
}