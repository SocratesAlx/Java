// Addition program that inputs two numbers then displays their sum.
import java.util.Scanner; // program uses class Scanner

public class Addition 
{
    //main method begins execution of Java application

    public static void main(String[] args)
    {
        // create a Scanner to obtain input from the command window
        Scanner input = new Scanner(System.in);

        int number1; //first number to add
        int number2; //second number to add
        int sum;// sum of number 1 and number2

        System.out.print("Enter first interger: ");
        number1 = input.nextInt(); // read first number from user

        System.out.print("Enter second interger: ");
        number2 = input.nextInt(); // read second number from user

        sum = number1 + number2; //  add numbers,then store total in sum

        System.out.printf("Sum is %d%n", sum);
        input.close(); // close the scanner
    } //  end method main
} //  end class Addition