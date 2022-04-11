// Name:		Dora Avun
// Program Number: (#3) StarPatternDoraAvun
// IDE: 		IntelliJ IDEA (2021.3.1)

import java.util.Scanner;  // Import the Scanner class
import static java.lang.Integer.parseInt; //to convert string to int

public class StarPatternDoraAvun {
    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please enter the number of rows: ");

        String rowCount = scan.nextLine();  // Read user input
        int rows = parseInt(rowCount); //write user input into an int.

        printPyramid(rows, rows);
    }


    static void printStar(int i, int n) 
    {
        int numstars;
        for (numstars = i*2 -1; numstars > 0; numstars--)
        {
            System.out.print("*");
        }
    }
    static void printPyramid(int i, int n)
    {
        if(i <= 0)
        {
            return;
        }
        else
        {
            //spacer(i);
            printStar(n - i, i); //call printStar method
            System.out.println("");
        }

        printPyramid(i - 1, n); // recursively call printPyramid.


    }
}


