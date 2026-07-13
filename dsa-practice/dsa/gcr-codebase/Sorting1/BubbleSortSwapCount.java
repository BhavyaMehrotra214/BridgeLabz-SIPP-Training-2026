import java.util.Scanner;
public class BubbleSortSwapCount {
    public static int bubbleSortAndCountSwaps(int[] nums) {
        int n = nums.length;
        int swapCount = 0;

        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {

                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;

                    swapCount++;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }

        return swapCount;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int swaps = bubbleSortAndCountSwaps(nums);

        System.out.println("Total Swaps = " + swaps);

        sc.close();
    }
}