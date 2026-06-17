import java.util.Scanner;
public class FactorsProgram {
    static int[] findFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                count++;
        }
        int[] factors = new int[count];
        int index = 0;

        for (int i = 1; i <= n; i++) {
            if (n % i == 0)
                factors[index++] = i;
        }
        return factors;
    }
    static int findSum(int[] factors) {
        int sum = 0;
        for (int factor : factors)
            sum += factor;
        return sum;
    }
    static long findProduct(int[] factors) {
        long product = 1;
        for (int factor : factors)
            product *= factor;
        return product;
    }
    static double findSumOfSquares(int[] factors) {
        double sum = 0;
        for (int factor : factors)
            sum += Math.pow(factor, 2);
        return sum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int num = sc.nextInt();
        int[] factors = findFactors(num);

        System.out.print("Factors: ");
        for (int factor : factors)
            System.out.print(factor + " ");
        System.out.println("\nSum = " + findSum(factors));
        System.out.println("Product = " + findProduct(factors));
        System.out.println("Sum of Squares = " + findSumOfSquares(factors));
    }
}