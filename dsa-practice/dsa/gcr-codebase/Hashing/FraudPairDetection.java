import java.util.HashMap;

public class FraudPairDetection {

    static int[] findFraudPair(int[] amounts, int target) {

        HashMap<Integer, Integer> seen = new HashMap<>();

        for (int i = 0; i < amounts.length; i++) {

            int complement = target - amounts[i];

            if (seen.containsKey(complement)) {
                return new int[]{seen.get(complement), i};
            }

            seen.put(amounts[i], i);
        }

        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

        int[] amounts = {10, 15, 3, 7};

        int target = 17;

        int[] result = findFraudPair(amounts, target);

        if (result[0] != -1) {
            System.out.println("Pair Found at Indices: " + result[0] + " " + result[1]);
        } else {
            System.out.println("Pair Not Found");
        }
    }
}