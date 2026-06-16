import java.util.Scanner;
public class FriendsInfo {
    static String findYoungest(int[] age) {
        String[] names = {"Amar", "Akbar", "Anthony"};
        int minIndex = 0;
        for (int i = 1; i < age.length; i++) {
            if (age[i] < age[minIndex])
                minIndex = i;
        }
        return names[minIndex];
    }
    static String findTallest(double[] height) {

        String[] names = {"Amar", "Akbar", "Anthony"};

        int maxIndex = 0;

        for (int i = 1; i < height.length; i++) {
            if (height[i] > height[maxIndex])
                maxIndex = i;
        }

        return names[maxIndex];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] age = new int[3];
        double[] height = new double[3];

        for (int i = 0; i < 3; i++) {

            System.out.print("Age: ");
            age[i] = sc.nextInt();

            System.out.print("Height: ");
            height[i] = sc.nextDouble();
        }

        System.out.println("Youngest = " + findYoungest(age));
        System.out.println("Tallest = " + findTallest(height));
    }
}