import java.util.Scanner;
public class LargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1 = sc.nextInt();
        int num2 = sc.nextInt();
        int num3 = sc.nextInt();

        boolean firstLargest = (num1 > num2 && num1 > num3);
        boolean secondLargest = (num2 > num1 && num2 > num3);
        boolean thirdLargest = (num3 > num1 && num3 > num2);

        System.out.println("Is the first number the largest? " + firstLargest);
        System.out.println("Is the second number the largest? " + secondLargest);
        System.out.println("Is the third number the largest? " + thirdLargest);
        sc.close();
    }
}