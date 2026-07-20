import java.util.HashMap;

public class RevenueSubarraySum {

    static int subarraySumEqualsK(int[] revenueChanges, int k) {

        HashMap<Integer, Integer> prefixCount = new HashMap<>();

        prefixCount.put(0, 1);

        int runningSum = 0;
        int answer = 0;

        for (int change : revenueChanges) {

            runningSum += change;

            answer += prefixCount.getOrDefault(runningSum - k, 0);

            prefixCount.put(runningSum,
                    prefixCount.getOrDefault(runningSum, 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] revenueChanges = {1, 2, 3, -2, 5, -3, 1};

        int k = 3;

        int result = subarraySumEqualsK(revenueChanges, k);

        System.out.println("Number of Subarrays = " + result);
    }
}