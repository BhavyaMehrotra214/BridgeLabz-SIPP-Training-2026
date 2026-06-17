import java.util.Scanner;
public class StudentVoteChecker {
    public boolean canStudentVote(int age) {
        if (age < 0)
            return false;
        return age >= 18;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];

        StudentVoteChecker obj = new StudentVoteChecker();

        for (int i = 0; i < ages.length; i++) {

            System.out.print("Enter Age: ");
            ages[i] = sc.nextInt();

            if (obj.canStudentVote(ages[i]))
                System.out.println("Can Vote");
            else
                System.out.println("Cannot Vote");
        }
    }
}