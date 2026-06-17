import java.util.Scanner;
public class TemplePuzzle {
    static int moves = 0;
    static void towerOfHanoi(int n, char source, char auxiliary, char destination) {
        if (n == 1) {
            System.out.println("Move disk 1 from " + source + " to " + destination);
            moves++;
            return;
        }
        towerOfHanoi(n - 1, source, destination, auxiliary);
        System.out.println("Move disk " + n + " from " + source + " to " + destination);
        moves++;
        towerOfHanoi(n - 1, auxiliary, source, destination);
    }
    static int binarySearch(int[] arr, int low, int high, int key) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (arr[mid] == key) {
            return mid;
        }
        if (key < arr[mid]) {
            return binarySearch(arr, low, mid - 1, key);
        }
        return binarySearch(arr, mid + 1, high, key);
    }

    static int sumOfDigits(int n) {
        if (n == 0) {
            return 0;
        }
        return n % 10 + sumOfDigits(n / 10);
    }
    static String reverseString(String str) {
        if (str.length() <= 1) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    static boolean isBalanced(String str, int count, int index) {
        if (count < 0) {
            return false;
        }

        if (index == str.length()) {
            return count == 0;
        }

        if (str.charAt(index) == '(') {
            return isBalanced(str, count + 1, index + 1);
        }

        if (str.charAt(index) == ')') {
            return isBalanced(str, count - 1, index + 1);
        }

        return isBalanced(str, count, index + 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();

        towerOfHanoi(n, 'A', 'B', 'C');
        System.out.println("Total Moves = " + moves);

        int[] prices = {100, 200, 300, 400, 500, 600};

        System.out.print("Enter price to search: ");
        int key = sc.nextInt();

        int result = binarySearch(prices, 0, prices.length - 1, key);

        if (result != -1) {
            System.out.println("Found at index " + result);
        } else {
            System.out.println("Not Found");
        }
        System.out.print("Enter number for sum of digits: ");
        int num = sc.nextInt();
        System.out.println("Sum of Digits = " + sumOfDigits(num));
        sc.nextLine();
        System.out.print("Enter string: ");
        String str = sc.nextLine();
        System.out.println("Reversed String = " + reverseString(str));

        System.out.print("Enter parentheses expression: ");
        String exp = sc.nextLine();

        if (isBalanced(exp, 0, 0)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
        sc.close();
    }
}