import java.util.*;

public class OnCallRotationScheduling {

    public List<List<String>> generateSchedules(String[] engineers) {

        List<List<String>> result = new ArrayList<>();

        boolean[] used = new boolean[engineers.length];

        backtrack(engineers, used, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(String[] engineers,
                           boolean[] used,
                           List<String> path,
                           List<List<String>> result) {

        if (path.size() == engineers.length) {

            result.add(new ArrayList<>(path));
            return;

        }

        for (int i = 0; i < engineers.length; i++) {

            if (used[i]) {
                continue;
            }

            used[i] = true;
            path.add(engineers[i]);

            backtrack(engineers, used, path, result);

            path.remove(path.size() - 1);

            used[i] = false;
        }
    }

    public static void main(String[] args) {

        OnCallRotationScheduling obj = new OnCallRotationScheduling();

        String[] engineers = {"Alice", "Bob", "Charlie"};

        List<List<String>> ans = obj.generateSchedules(engineers);

        for (List<String> list : ans) {
            System.out.println(list);
        }
    }
}