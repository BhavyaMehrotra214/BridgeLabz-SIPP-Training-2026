public class DepartmentLCAFinder {

    static class DepartmentNode {

        int val;
        DepartmentNode left;
        DepartmentNode right;

        DepartmentNode(int val) {
            this.val = val;
        }
    }

    // Insert into BST
    static DepartmentNode insert(DepartmentNode root, int val) {

        if (root == null) {
            return new DepartmentNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Find Lowest Common Ancestor
    static DepartmentNode lowestCommonAncestor(DepartmentNode root, int p, int q) {

        DepartmentNode current = root;

        while (current != null) {

            if (p < current.val && q < current.val) {
                current = current.left;
            }

            else if (p > current.val && q > current.val) {
                current = current.right;
            }

            else {
                return current;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        DepartmentNode root = null;

        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 70);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 60);
        root = insert(root, 80);

        int p = 20;
        int q = 40;

        DepartmentNode lca = lowestCommonAncestor(root, p, q);

        System.out.println("Lowest Common Ancestor = " + lca.val);
    }
}