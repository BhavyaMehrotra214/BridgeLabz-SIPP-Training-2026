public class CommunicationTreeDiameter {

    static class EmployeeNode {

        int val;
        EmployeeNode left;
        EmployeeNode right;

        EmployeeNode(int val) {
            this.val = val;
        }
    }

    static int diameter = 0;

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

    // Find Diameter
    static int longestCommunicationPath(EmployeeNode root) {

        diameter = 0;
        heightAndUpdateDiameter(root);

        return diameter;
    }

    static int heightAndUpdateDiameter(EmployeeNode node) {

        if (node == null) {
            return -1;
        }

        int leftHeight = heightAndUpdateDiameter(node.left);
        int rightHeight = heightAndUpdateDiameter(node.right);

        diameter = Math.max(diameter, leftHeight + rightHeight + 2);

        return Math.max(leftHeight, rightHeight) + 1;
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

        System.out.println("Diameter = " + longestCommunicationPath(root));
    }
}