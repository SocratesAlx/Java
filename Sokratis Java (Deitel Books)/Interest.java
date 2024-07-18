// Compound interest calculations with for.

public class Interest 
{
    public static void main(String[] args)
    {
        double amount; // amount on deposit at end of each year
        double principal = 1000.0; // initial amout before interest
        double rate = 0.05; //  interest


        // display headers
        System.out.printf("%s%20s%n", "Year", "Amount on deposit"); // the %20s indicates that the value should be displayed with a width of 20,that is printf displays the value with
        // at least 20 character positions

        // calculate amount on deposit for each of ten years
        for (int year = 1; year <= 10; ++year)
        {

            // calculate new amount for specified year
            amount = principal * Math.pow(1.0 + rate, year);

            // display the year and the amount
            System.out.printf("%4d%,20.2f%n", year, amount);
        }

    }
} // end class Interest
