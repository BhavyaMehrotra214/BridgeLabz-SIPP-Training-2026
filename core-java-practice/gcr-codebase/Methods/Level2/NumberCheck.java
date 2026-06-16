import java.util.Scanner;
public class NumberCheck {

    static boolean isPositive(int num) {
        return num >= 0;
    }

    static boolean isEven(int num) {
        return num % 2 == 0;
    }

    static int compare(int n1, int n2) {

        if (n1 > n2)
            return 1;
        else if (n1 == n2)
            return 0;

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[5];

        for (int i = 0; i < arr.length; i++) {

            System.out.print("Enter Number: ");
            arr[i] = sc.nextInt();

            if (isPositive(arr[i])) {

                if (isEven(arr[i]))
                    System.out.println("Positive Even");
                else
                    System.out.println("Positive Odd");

            } else {
                System.out.println("Negative");
            }
        }

        int result = compare(arr[0], arr[4]);

        if (result == 1)
            System.out.println("First Element Greater");
        else if (result == 0)
            System.out.println("Both Equal");
        else
            System.out.println("Last Element Greater");
    }
}