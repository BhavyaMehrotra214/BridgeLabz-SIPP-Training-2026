public class CategoryTreeHeight {

    static class CategoryNode {

        int val;
        CategoryNode left;
        CategoryNode right;

        CategoryNode(int val) {
            this.val = val;
        }
    }

    // Insert into BST
    static CategoryNode insert(CategoryNode root, int val) {

        if (root == null) {
            return new CategoryNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Find Height
    static int height(CategoryNode node) {

        if (node == null) {
            return -1;
        }

        int leftHeight = height(node.left);
        int rightHeight = height(node.right);

        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Check Threshold
    static boolean isTooDeep(CategoryNode root, int threshold) {

        return height(root) > threshold;
    }

    public static void main(String[] args) {

        CategoryNode root = null;

        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 70);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 60);
        root = insert(root, 80);

        int threshold = 2;

        System.out.println("Tree Height = " + height(root));
        System.out.println("Exceeds Threshold? " + isTooDeep(root, threshold));
    }
}