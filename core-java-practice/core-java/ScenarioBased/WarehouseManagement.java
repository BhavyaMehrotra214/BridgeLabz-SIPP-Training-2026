import java.util.*;
public class WarehouseManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        int[] stock = new int[n];
        System.out.println("Enter stock quantities:");
        for (int i = 0; i < n; i++) {
            stock[i] = sc.nextInt();
        }
        int max = stock[0];
        int min = stock[0];
        int total = 0;

        HashSet<Integer> seen = new HashSet<>();
        HashSet<Integer> duplicates = new HashSet<>();

        for (int qty : stock) {
            max = Math.max(max, qty);
            min = Math.min(min, qty);
            total += qty;

            if (!seen.add(qty)) {
                duplicates.add(qty);
            }
        }

        System.out.println("Maximum Stock = " + max);
        System.out.println("Minimum Stock = " + min);
        System.out.println("Total Stock = " + total);

        if (duplicates.isEmpty()) {
            System.out.println("No Duplicates Found");
        } else {
            System.out.println("Duplicate Quantities: " + duplicates);
        }

        System.out.print("Enter k for rotation: ");
        int k = sc.nextInt();
        k %= n;
        reverse(stock, 0, n - 1);
        reverse(stock, 0, k - 1);
        reverse(stock, k, n - 1);

        System.out.println("Array after rotation:");
        System.out.println(Arrays.toString(stock));

        System.out.print("Enter rows: ");
        int rows = sc.nextInt();

        System.out.print("Enter columns: ");
        int cols = sc.nextInt();

        int[][] shelf = new int[rows][cols];

        System.out.println("Enter shelf grid values:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                shelf[i][j] = sc.nextInt();
            }
        }

        int[][] transpose = new int[cols][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = shelf[i][j];
            }
        }
        System.out.println("Transpose Matrix:");
        for (int[] row : transpose) {
            System.out.println(Arrays.toString(row));
        }

        sc.close();
    }
    static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}