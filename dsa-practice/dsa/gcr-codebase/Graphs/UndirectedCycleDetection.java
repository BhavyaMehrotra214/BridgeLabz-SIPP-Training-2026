import java.util.*;

public class UndirectedCycleDetection {

    public static boolean hasWiringLoop(
            Map<Integer, List<Integer>> circuit,
            int n) {

        Set<Integer> visited = new HashSet<>();

        for (int v = 0; v < n; v++) {

            if (!visited.contains(v)) {

                if (dfsCycleCheck(circuit, v, -1, visited)) {

                    return true;

                }
            }
        }

        return false;
    }

    public static boolean dfsCycleCheck(
            Map<Integer, List<Integer>> circuit,
            int node,
            int parent,
            Set<Integer> visited) {

        visited.add(node);

        for (int neighbor : circuit.getOrDefault(node, Collections.emptyList())) {

            if (!visited.contains(neighbor)) {

                if (dfsCycleCheck(circuit, neighbor, node, visited)) {

                    return true;

                }

            } else if (neighbor != parent) {

                return true;

            }
        }

        return false;
    }

    public static void main(String[] args) {

        Map<Integer, List<Integer>> graph = new HashMap<>();

        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(0, 2));
        graph.put(2, Arrays.asList(0, 1));

        System.out.println(hasWiringLoop(graph, 3));
    }
}