public class ConsecutiveSensor {
    public static boolean isStrictlyIncreasing(int[] arr, int i) {
        if (i == arr.length - 1) {
            return true;
        }
        if (arr[i] >= arr[i + 1]) {
            return false;
        }
        return isStrictlyIncreasing(arr, i + 1);
    }
    public static void main(String[] args) {
        int[] arr1 = {12, 15, 18, 22, 30};
        int[] arr2 = {12, 15, 14, 22};
        System.out.println(isStrictlyIncreasing(arr1, 0)); // true
        System.out.println(isStrictlyIncreasing(arr2, 0)); // false
    }
}