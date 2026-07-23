import java.util.*;
public class TopKHighestSpendingCustomers {
    static List<Integer> topKLargest(int[] arr, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : arr) {

            if (minHeap.size() < k)
                minHeap.offer(num);

            else if (num > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(num);
            }
        }
        return new ArrayList<>(minHeap);
    }
    public static void main(String[] args) {

        int[] transactions = {20, 50, 10, 80, 90, 60};

        System.out.println(topKLargest(transactions, 3));
    }
}