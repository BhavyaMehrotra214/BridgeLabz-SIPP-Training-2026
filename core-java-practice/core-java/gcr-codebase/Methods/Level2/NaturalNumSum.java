import java.util.Scanner;
public class NaturalNumSum {
    static int recursiveSum(int n) {
        if (n == 1)
            return 1;
        return n + recursiveSum(n - 1);
    }
    static int formulaSum(int n) {
        return n * (n + 1) / 2;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Not a Natural Number");
            return;
        }

        int sum1 = recursiveSum(n);
        int sum2 = formulaSum(n);

        System.out.println("Recursive Sum = " + sum1);
        System.out.println("Formula Sum = " + sum2);

        System.out.println(sum1 == sum2 ? "Both are Equal" : "Not Equal");
    }
}