import java.util.Scanner;

public class ClassAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // Corrected initialization of Scanner
        int total = 0;
        int gradeCounter = 0;

        System.out.print("Enter grade or -1 to exit: "); // Corrected the print statement
        int grade = input.nextInt();

        while (grade != -1) {
            total = total + grade;
            gradeCounter = gradeCounter + 1;

            System.out.print("Enter grade or -1 to exit: "); // Corrected the print statement
            grade = input.nextInt();
        }

        if (gradeCounter != 0) {
            double average = (double) total / gradeCounter;
            System.out.printf("%nTotal of the %d grades entered is %d%n", gradeCounter, total);
            System.out.printf("Class average is %.2f%n", average);
        } else {
            System.out.println("No grades entered"); // Corrected the print statement
        }
        input.close(); // close the scanner
    }
}
