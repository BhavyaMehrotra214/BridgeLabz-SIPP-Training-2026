import java.util.Scanner;
public class LargestDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();
        int[] digits = new int[10];
        int index = 0;
        while (number != 0 && index < 10) {
            digits[index++] = (int) (number % 10);
            number /= 10;
        }
        int lar = Integer.MIN_VALUE;
        int secondLar = Integer.MIN_VALUE;
        for (int i = 0; i < index; i++) {
            if (digits[i] > lar) {
                secondLar = lar;
                lar = digits[i];
            } else if (digits[i] > secondLar && digits[i] != lar) {
                secondLar = digits[i];
            }
        }
        System.out.println("Largest = " + lar);
        System.out.println("Second Largest = " + secondLar);
    }
}