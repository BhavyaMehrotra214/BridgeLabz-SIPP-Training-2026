import java.util.Scanner;
class MathWizard {
    int instanceVar = 100;
    boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
    int factorial(int n) {
        int fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    double factorial(double n) {
        double fact = 1;

        for (int i = 1; i <= n; i++) {
            fact *= i;
        }

        return fact;
    }

    void fibonacci(int n) {
        int a = 0, b = 1;

        for (int i = 1; i <= n; i++) {
            System.out.print(a + " ");
            int c = a + b;
            a = b;
            b = c;
        }
        System.out.println();
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    int power(int base, int exp) {
        int result = 1;

        for (int i = 1; i <= exp; i++) {
            result *= base;
        }

        return result;
    }

    void showScope() {
        int localVar = 50;

        System.out.println("Local Variable = " + localVar);
        System.out.println("Instance Variable = " + instanceVar);
    }
}

class main{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MathWizard m = new MathWizard();

        System.out.print("Enter number: ");
        int n = sc.nextInt();

        System.out.println("Prime = " + m.isPrime(n));
        System.out.println("Factorial = " + m.factorial(n));

        System.out.print("Enter fibonacci terms: ");
        int terms = sc.nextInt();
        m.fibonacci(terms);

        System.out.print("Enter two nums: ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        System.out.println("GCD = " + m.gcd(a, b));
        System.out.println("LCM = " + m.lcm(a, b));
        System.out.print("Enter base and exponent: ");
        int base = sc.nextInt();
        int exp = sc.nextInt();

        System.out.println("Power = " + m.power(base, exp));
        m.showScope();
    }
}