import java.util.Scanner;
public class NumberCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = sc.nextInt();
        }
        for (int num : numbers) {

            if (num > 0) {
                System.out.println(num + (num % 2 == 0
                        ? " is Positive and Even"
                        : " is Positive and Odd"));
            }
            else if (num < 0) {
                System.out.println(num + " is Negative");
            }
            else {
                System.out.println(num + " is Zero");
            }
        }
        int first = numbers[0];
        int last = numbers[numbers.length - 1];

        if (first == last) {
            System.out.println("First and Last elements are Equal");
        } else if (first > last) {
            System.out.println("First element is Greater than Last element");
        } else {
            System.out.println("First element is Less than Last element");
        }
        sc.close();
    }
}