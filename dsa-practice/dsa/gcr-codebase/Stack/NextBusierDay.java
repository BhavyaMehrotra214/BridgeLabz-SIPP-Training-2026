import java.util.Stack;

class NextBusierDay {

    static int[] nextGreaterElement(int[] visitors) {

        int n = visitors.length;

        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Initialize all answers with -1
        for (int i = 0; i < n; i++) {
            answer[i] = -1;
        }

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                    visitors[i] > visitors[stack.peek()]) {

                int index = stack.pop();
                answer[index] = visitors[i];
            }

            stack.push(i);
        }

        return answer;
    }

    public static void main(String[] args) {

        int[] visitors = {4, 5, 2, 10, 8};

        int[] result = nextGreaterElement(visitors);

        System.out.println("Next Greater Elements:");

        for (int value : result) {
            System.out.print(value + " ");
        }
    }
}