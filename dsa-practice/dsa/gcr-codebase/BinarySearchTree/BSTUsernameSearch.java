public class BSTUsernameSearch {

    static class UserNode {

        int val;
        UserNode left;
        UserNode right;

        UserNode(int val) {
            this.val = val;
        }
    }

    static boolean search(UserNode root, int target) {

        UserNode current = root;

        while (current != null) {

            if (target == current.val) {
                return true;
            }

            if (target < current.val) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

        return false;
    }

    public static void main(String[] args) {

        UserNode root = new UserNode(50);

        root.left = new UserNode(30);
        root.right = new UserNode(70);

        root.left.left = new UserNode(20);
        root.left.right = new UserNode(40);

        root.right.left = new UserNode(60);
        root.right.right = new UserNode(80);

        int target = 60;

        if (search(root, target)) {
            System.out.println("Username Found");
        } else {
            System.out.println("Username Not Found");
        }
    }
}