import java.util.Arrays;

public class BubbleSort {

    public static void bubbleSort(int arr[]) {

        int swaps = 0;

        for (int i = 0; i < arr.length - 1; i++) {

            boolean swapped = false;

            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swaps++;
                    swapped = true;
                }
            }

            if (!swapped) {
                System.out.println("Already Sorted (Best Case)");
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
        System.out.println("Total Swaps = " + swaps);
    }

    public static void main(String args[]) {

        int arr[] = {64,25,12,22,11};

        bubbleSort(arr);

        System.out.println("Gold   : " + arr[arr.length-1]);
        System.out.println("Silver : " + arr[arr.length-2]);
        System.out.println("Bronze : " + arr[arr.length-3]);
    }
}