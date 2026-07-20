public class FolderTreeDeletion {

    static class FolderNode {

        int val;
        FolderNode left;
        FolderNode right;

        FolderNode(int val) {
            this.val = val;
        }
    }

    // Insert into BST
    static FolderNode insert(FolderNode root, int val) {

        if (root == null) {
            return new FolderNode(val);
        }

        if (val < root.val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Postorder Traversal (Delete)
    static void deleteFolderTree(FolderNode node) {

        if (node == null) {
            return;
        }

        // Delete left subtree
        deleteFolderTree(node.left);

        // Delete right subtree
        deleteFolderTree(node.right);

        // Delete current node
        System.out.println("Deleting Folder: " + node.val);
    }

    public static void main(String[] args) {

        FolderNode root = null;

        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 70);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 60);
        root = insert(root, 80);

        System.out.println("Folder Deletion Order (Postorder):");

        deleteFolderTree(root);
    }
}