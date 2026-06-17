import java.util.Scanner;
public class StudentGrade2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[][] marks = new int[n][3];
        double[] percentage = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Physics: ");
            marks[i][0] = sc.nextInt();

            System.out.print("Chemistry: ");
            marks[i][1] = sc.nextInt();

            System.out.print("Maths: ");
            marks[i][2] = sc.nextInt();

            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;
            if (percentage[i] >= 90)
                grade[i] = "A";
            else if (percentage[i] >= 75)
                grade[i] = "B";
            else if (percentage[i] >= 50)
                grade[i] = "C";
            else
                grade[i] = "D";
        }

        System.out.println("\nPercentage\tGrade");

        for (int i = 0; i < n; i++) {
            System.out.printf("%.2f\t\t%s%n",
                    percentage[i], grade[i]);
        }
    }
}