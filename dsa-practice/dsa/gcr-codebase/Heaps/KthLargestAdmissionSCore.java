import java.util.*;
public class KthLargestAdmissionSCore {
    static int findKthLargest(int[] scores, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int score : scores) {

            if (minHeap.size() < k)
                minHeap.offer(score);

            else if (score > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(score);
            }
        }
        return minHeap.peek();
    }
    public static void main(String[] args) {

        int[] scores = {20, 50, 10, 80, 90, 60};

        System.out.println(findKthLargest(scores, 3));
    }
}