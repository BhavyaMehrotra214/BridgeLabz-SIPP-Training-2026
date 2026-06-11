import java.util.Scanner;
public class FeetToYards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter distance in feet: ");
        double distanceInFeet = sc.nextDouble();
        double yards = distanceInFeet / 3;
        double miles = yards / 1760;
        System.out.println("Distance in feet is " + distanceInFeet + ", in yards is " + yards + " and in miles is " + miles);
    }
}
