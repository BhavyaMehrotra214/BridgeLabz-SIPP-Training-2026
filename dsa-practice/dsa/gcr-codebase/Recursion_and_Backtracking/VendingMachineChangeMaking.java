import java.util.*;

public class VendingMachineChangeMaking {

    public List<List<Integer>> makeChange(int[] coins, int target) {

        Arrays.sort(coins);

        List<List<Integer>> result = new ArrayList<>();

        backtrack(coins, target, 0, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] coins,
                           int target,
                           int start,
                           int sum,
                           List<Integer> path,
                           List<List<Integer>> result) {

        if (sum == target) {

            result.add(new ArrayList<>(path));
            return;

        }

        for (int i = start; i < coins.length; i++) {

            if (sum + coins[i] > target) {
                break;
            }

            path.add(coins[i]);

            backtrack(coins, target, i, sum + coins[i], path, result);

            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {

        VendingMachineChangeMaking obj = new VendingMachineChangeMaking();

        int[] coins = {2, 3, 5};

        List<List<Integer>> ans = obj.makeChange(coins, 8);

        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }
}