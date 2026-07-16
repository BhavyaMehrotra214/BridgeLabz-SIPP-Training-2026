public class FixedWindow_CPUSpikeDetection {

    public static int maxSubarrayOfSizeK(int[] cpuLoad, int k) {

        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int start = 0;

        for (int end = 0; end < cpuLoad.length; end++) {

            windowSum += cpuLoad[end];

            if (end >= k - 1) {

                maxSum = Math.max(maxSum, windowSum);

                windowSum -= cpuLoad[start];
                start++;
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {

        int[] cpuLoad = {20, 40, 35, 50, 10, 60, 25};
        int k = 3;

        System.out.println(maxSubarrayOfSizeK(cpuLoad, k));
    }
}