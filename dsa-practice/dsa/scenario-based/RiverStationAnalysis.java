import java.util.*;
public class RiverStationAnalysis {

    //  Longest Contiguous Period Within a Range (Sliding Window)
    public static int longestStablePeriod(int[] levels, int limit) {

        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < levels.length; right++) {

            while (!maxDeque.isEmpty() && levels[maxDeque.peekLast()] < levels[right])
                maxDeque.pollLast();

            while (!minDeque.isEmpty() && levels[minDeque.peekLast()] > levels[right])
                minDeque.pollLast();

            maxDeque.offerLast(right);
            minDeque.offerLast(right);

            while (levels[maxDeque.peekFirst()] - levels[minDeque.peekFirst()] > limit) {

                if (maxDeque.peekFirst() == left)
                    maxDeque.pollFirst();

                if (minDeque.peekFirst() == left)
                    minDeque.pollFirst();

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    //  Three Sum (Unique Triplets)
    public static List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1])
                        left++;

                    while (left < right && nums[right] == nums[right - 1])
                        right--;

                    left++;
                    right--;
                }

                else if (sum < 0)
                    left++;
                else
                    right--;
            }
        }

        return result;
    }

    //  Maximum Average Subarray of Length k
    public static double maxAverage(int[] nums, int k) {

        int sum = 0;

        for (int i = 0; i < k; i++)
            sum += nums[i];

        int maxSum = sum;

        for (int i = k; i < nums.length; i++) {

            sum += nums[i] - nums[i - k];

            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of water level readings:");
        int n = sc.nextInt();

        int[] levels = new int[n];

        System.out.println("Enter water levels:");

        for (int i = 0; i < n; i++)
            levels[i] = sc.nextInt();

        System.out.println("Enter allowed range (limit):");
        int limit = sc.nextInt();

        System.out.println("Longest Stable Period = "
                + longestStablePeriod(levels, limit));

        System.out.println("\nEnter size of pollution index array:");
        int m = sc.nextInt();

        int[] pollution = new int[m];

        System.out.println("Enter pollution indices:");

        for (int i = 0; i < m; i++)
            pollution[i] = sc.nextInt();

        List<List<Integer>> triplets = threeSum(pollution);

        System.out.println("Unique Triplets with Sum = 0");

        for (List<Integer> triplet : triplets)
            System.out.println(triplet);
        System.out.println("\nEnter size of array for maximum average:");
        int p = sc.nextInt();

        int[] arr = new int[p];

        System.out.println("Enter elements:");

        for (int i = 0; i < p; i++)
            arr[i] = sc.nextInt();

        System.out.println("Enter k:");
        int k = sc.nextInt();

        System.out.println("Maximum Average = " + maxAverage(arr, k));

        sc.close();
    }
}