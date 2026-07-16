import java.util.Scanner;
public class BinarySearch {
    //  Normal Binary Search
    public static int binarySearch(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    //  Search in Rotated Sorted Array
    public static int searchRotated(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target)
                return mid;

            // Left half is sorted
            if (arr[low] <= arr[mid]) {

                if (target >= arr[low] && target < arr[mid])
                    high = mid - 1;
                else
                    low = mid + 1;
            }

            // Right half is sorted
            else {

                if (target > arr[mid] && target <= arr[high])
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }

        return -1;
    }

    //  First Occurrence
    public static int firstOccurrence(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                ans = mid;
                high = mid - 1;
            } else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return ans;
    }

    //  Last Occurrence
    public static int lastOccurrence(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == target) {
                ans = mid;
                low = mid + 1;
            } else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return ans;
    }

    // Find Minimum in Rotated Sorted Array
    public static int findMinimum(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] > arr[high])
                low = mid + 1;
            else
                high = mid;
        }

        return arr[low];
    }

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in sorted array:");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter sorted elements:");

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println("Enter target for Binary Search:");
        int target = sc.nextInt();

        int index = binarySearch(arr, target);

        if (index != -1)
            System.out.println("Target found at index : " + index);
        else
            System.out.println("Target not found.");

        System.out.println("\nEnter number of elements in rotated array:");
        int m = sc.nextInt();

        int[] rotated = new int[m];

        System.out.println("Enter rotated sorted array:");

        for (int i = 0; i < m; i++)
            rotated[i] = sc.nextInt();

        System.out.println("Enter target to search in rotated array:");
        int target2 = sc.nextInt();

        int result = searchRotated(rotated, target2);

        if (result != -1)
            System.out.println("Target found at index : " + result);
        else
            System.out.println("Target not found.");

        System.out.println("\nEnter target to find first and last occurrence:");
        int repeat = sc.nextInt();

        int first = firstOccurrence(arr, repeat);
        int last = lastOccurrence(arr, repeat);

        if (first == -1)
            System.out.println("Element not found.");
        else {
            System.out.println("First Occurrence : " + first);
            System.out.println("Last Occurrence  : " + last);
        }
        int minimum = findMinimum(rotated);

        System.out.println("\nMinimum Element in Rotated Array : " + minimum);

        sc.close();
    }
}