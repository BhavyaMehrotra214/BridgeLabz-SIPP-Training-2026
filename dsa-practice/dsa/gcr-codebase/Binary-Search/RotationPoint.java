public class RotationPoint {

    public static int findRotationPoint(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] > arr[right])
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    public static void main(String[] args) {

        int[] arr = {15,18,2,3,6,12};

        int index = findRotationPoint(arr);

        System.out.println("Rotation Point Index = " + index);
        System.out.println("Smallest Element = " + arr[index]);
    }
}