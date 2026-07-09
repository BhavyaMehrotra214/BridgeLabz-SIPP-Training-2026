import java.util.Scanner;

public class CustomerOrderValuesMergeSort {

    static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {

        int[] L = new int[mid - left + 1];
        int[] R = new int[right - mid];

        for (int i = 0; i < L.length; i++)
            L[i] = arr[left + i];

        for (int i = 0; i < R.length; i++)
            R[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = left;

        while (i < L.length && j < R.length) {

            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }

        while (i < L.length)
            arr[k++] = L[i++];

        while (j < R.length)
            arr[k++] = R[j++];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] orders = new int[n];

        for (int i = 0; i < n; i++)
            orders[i] = sc.nextInt();

        mergeSort(orders, 0, n - 1);

        for (int value : orders)
            System.out.print(value + " ");

        sc.close();
    }
}