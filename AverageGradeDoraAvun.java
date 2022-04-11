// Name:		Dora Avun
// Program Number: (#2) AverageGradeDoraAvun
// IDE: 		IntelliJ IDEA (2021.3.1)
import java.util.Scanner;  // Import the Scanner class
import static java.lang.Integer.parseInt; //to convert string to int

public class AverageGradeDoraAvun //class
{
    public static void main(String args[]) //main method
    {

        Scanner scan = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Please enter the number of students: ");

        String classSize = scan.nextLine();  // Read user input

        int[] grades = new int[parseInt(classSize)]; //convert user input(string) to integer to
                                                     // determine the size of the array.

        System.out.print("Please enter the grades: ");
        for (int i = 0; i < grades.length; i++) //write in the user input grades to an array using for loop.
        {
            String grade = scan.nextLine();  // Read user input
            grades[i] = parseInt(grade); //convert input string to integer.
        }
        //print out results.
        System.out.println("Class size: " + classSize);
        System.out.print("Entered Grades: ");
        for (int i = 0; i < grades.length; i++) //prints out grades in a viable format using for loop.
        {
            System.out.print(grades[i] + " "); //space after each grade.
        }
        //printing out average result calling a recurring method and adjusting double value to 2 decimals.
        System.out.println("\nGrade Avg: " + String.format("%.2f",findAverage(grades, 0, grades.length)));
    }

    static double findAverage(int[] grades, int i, int n) //method to find avg.
    {

        if (i == 0) //index is 0 by default, we recursively call the method and then divide the total to n and return.
        {
            return ((grades[i] + findAverage(grades, i + 1, n)) / n);
        }
        if (i == n-1) //if index is already the last grade, we just return grade, no more additions. (if there is 1 grade)
        {
            return grades[i];
        }
        // Creating summation until we reach the value n-1
        return (grades[i] + findAverage(grades, i+1, n));
    }
}
