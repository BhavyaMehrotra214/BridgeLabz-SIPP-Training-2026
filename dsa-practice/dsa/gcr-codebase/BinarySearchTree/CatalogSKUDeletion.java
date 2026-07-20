public class CatalogSKUDeletion {

    static class SKUNode {

        int val;
        SKUNode left;
        SKUNode right;

        SKUNode(int val) {
            this.val = val;
        }
    }

    // Insert Node
    static SKUNode insert(SKUNode root, int val) {

        if (root == null) {
            return new SKUNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else if (val > root.val) {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Delete Node
    static SKUNode delete(SKUNode root, int sku) {

        if (root == null) {
            return null;
        }

        if (sku < root.val) {
            root.left = delete(root.left, sku);
        }

        else if (sku > root.val) {
            root.right = delete(root.right, sku);
        }

        else {

            // Case 1: Leaf Node
            if (root.left == null && root.right == null) {
                return null;
            }

            // Case 2: One Child
            if (root.left == null) {
                return root.right;
            }

            if (root.right == null) {
                return root.left;
            }

            // Case 3: Two Children
            SKUNode successor = root.right;

            while (successor.left != null) {
                successor = successor.left;
            }

            root.val = successor.val;

            root.right = delete(root.right, successor.val);
        }

        return root;
    }

    // Inorder Traversal
    static void inorder(SKUNode root) {

        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        SKUNode root = null;

        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 70);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 60);
        root = insert(root, 80);

        System.out.println("Before Deletion:");
        inorder(root);

        root = delete(root, 50);

        System.out.println("\nAfter Deletion:");
        inorder(root);
    }
}