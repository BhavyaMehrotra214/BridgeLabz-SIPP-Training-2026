import java.util.*;

public class DirectedCycleDetection {

    public static boolean hasCircularDependency(
            Map<Integer, List<Integer>> tasks,
            int n) {

        int[] state = new int[n];

        for (int v = 0; v < n; v++) {

            if (state[v] == 0) {

                if (dfsCycleCheck(tasks, v, state)) {

                    return true;

                }
            }
        }

        return false;
    }

    public static boolean dfsCycleCheck(
            Map<Integer, List<Integer>> tasks,
            int node,
            int[] state) {

        state[node] = 1;

        for (int dep : tasks.getOrDefault(node, Collections.emptyList())) {

            if (state[dep] == 1) {

                return true;

            }

            if (state[dep] == 0 &&
                    dfsCycleCheck(tasks, dep, state)) {

                return true;

            }
        }

        state[node] = 2;

        return false;
    }

    public static void main(String[] args) {

        Map<Integer, List<Integer>> tasks = new HashMap<>();

        tasks.put(0, Arrays.asList(1));
        tasks.put(1, Arrays.asList(2));
        tasks.put(2, Arrays.asList(0));

        System.out.println(hasCircularDependency(tasks, 3));
    }
}