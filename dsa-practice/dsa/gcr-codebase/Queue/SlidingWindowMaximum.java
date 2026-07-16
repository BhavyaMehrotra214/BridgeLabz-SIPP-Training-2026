import java.util.ArrayDeque;
import java.util.Deque;

class SlidingWindowMaximum {

    static int[] maxThroughputWindow(int[] readings, int k) {

        int n = readings.length;

        int[] result = new int[n - k + 1];

        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Remove indices outside the current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // Remove smaller elements from the back
            while (!deque.isEmpty() &&
                    readings[deque.peekLast()] <= readings[i]) {
                deque.pollLast();
            }

            // Add current index
            deque.offerLast(i);

            // Store maximum when first window is complete
            if (i >= k - 1) {
                result[i - k + 1] = readings[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[] readings = {1, 3, -1, -3, 5, 3, 6, 7};

        int k = 3;

        int[] result = maxThroughputWindow(readings, k);

        System.out.println("Maximum in Every Window:");

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}