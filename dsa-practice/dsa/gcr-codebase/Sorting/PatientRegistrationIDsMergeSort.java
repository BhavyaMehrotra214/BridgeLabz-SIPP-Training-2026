import java.util.Scanner;

public class PatientRegistrationIDsMergeSort {

    static void mergeSort(int[] arr, int left, int right) {

        if (left < right) {

            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    static void merge(int[] arr, int left, int mid, int right) {

        int[] leftArr = new int[mid - left + 1];
        int[] rightArr = new int[right - mid];

        for (int i = 0; i < leftArr.length; i++)
            leftArr[i] = arr[left + i];

        for (int i = 0; i < rightArr.length; i++)
            rightArr[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = left;

        while (i < leftArr.length && j < rightArr.length) {

            if (leftArr[i] <= rightArr[j])
                arr[k++] = leftArr[i++];
            else
                arr[k++] = rightArr[j++];
        }

        while (i < leftArr.length)
            arr[k++] = leftArr[i++];

        while (j < rightArr.length)
            arr[k++] = rightArr[j++];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] ids = new int[n];

        for (int i = 0; i < n; i++)
            ids[i] = sc.nextInt();

        mergeSort(ids, 0, n - 1);

        for (int id : ids)
            System.out.print(id + " ");

        sc.close();
    }
}