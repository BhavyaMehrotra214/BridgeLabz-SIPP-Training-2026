import java.io.*;
import java.util.*;
public class SchoolResult {
    public static void main(String[] args) {
        String inputFile = "students.txt";
        String outputFile = "reportcard.txt";
        try {
            Scanner fileReader = new Scanner(new File(inputFile));

            FileWriter writer = new FileWriter(outputFile, true);

            writer.write("\nSTUDENT REPORT CARD \n");

            while (fileReader.hasNextLine()) {

                String line = fileReader.nextLine();
                String[] data = line.split(",");

                String name = data[0];

                int total = 0;
                int subjects = data.length - 1;

                for (int i = 1; i < data.length; i++) {
                    total += Integer.parseInt(data[i]);
                }

                double average = (double) total / subjects;

                writer.write("Name: " + name + "\n");
                writer.write("Average Marks: " +
                        String.format("%.2f", average) + "\n");

                if (average >= 90)
                    writer.write("Grade: A+\n");
                else if (average >= 75)
                    writer.write("Grade: A\n");
                else if (average >= 60)
                    writer.write("Grade: B\n");
                else
                    writer.write("Grade: C\n");

                writer.write("--\n");
            }

            fileReader.close();
            writer.close();

            System.out.println("Report card generated successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: Student data file not found.");
        } catch (IOException e) {
            System.out.println("Error while writing to file.");
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid marks format in file.");
        }
    }
}