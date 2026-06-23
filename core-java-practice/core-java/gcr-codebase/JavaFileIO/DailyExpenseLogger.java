import java.io.*;
import java.util.Scanner;

public class DailyExpenseLogger {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            FileWriter fw =
                    new FileWriter("expenses.txt", true);

            System.out.print("Category : ");
            String category = sc.nextLine();

            System.out.print("Amount : ");
            int amount = sc.nextInt();

            fw.write(category + " - " + amount);
            fw.write("\n");

            fw.close();

            System.out.println("Expense Saved");

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}