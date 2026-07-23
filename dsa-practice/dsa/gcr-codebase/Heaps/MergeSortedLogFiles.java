import java.util.*;
public class MergeSortedLogFiles {

    static class Node {

        int value;
        int listIndex;
        int elementIndex;

        Node(int value, int listIndex, int elementIndex) {
            this.value = value;
            this.listIndex = listIndex;
            this.elementIndex = elementIndex;
        }
    }
    static List<Integer> mergeKLists(List<List<Integer>> lists) {

        PriorityQueue<Node> minHeap = new PriorityQueue<>((a, b) -> a.value - b.value);

        for (int i = 0; i < lists.size(); i++) {
            if (!lists.get(i).isEmpty()) {
                minHeap.offer(new Node(lists.get(i).get(0), i, 0));
            }
        }
        List<Integer> result = new ArrayList<>();

        while (!minHeap.isEmpty()) {

            Node current = minHeap.poll();

            result.add(current.value);

            int next = current.elementIndex + 1;

            if (next < lists.get(current.listIndex).size()) {
                minHeap.offer(new Node(lists.get(current.listIndex).get(next), current.listIndex, next));
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<List<Integer>> lists = new ArrayList<>();

        lists.add(Arrays.asList(1, 4, 7));
        lists.add(Arrays.asList(2, 5, 8));
        lists.add(Arrays.asList(3, 6, 9));

        System.out.println(mergeKLists(lists));
    }
}