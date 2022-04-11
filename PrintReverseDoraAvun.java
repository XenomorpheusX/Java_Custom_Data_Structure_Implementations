// Name:		Dora Avun
// Program Number: (#1) PrintReverseDoraAvun
// IDE: 		IntelliJ IDEA (2021.3.1)

import java.util.Scanner;  // Import the Scanner class

public class PrintReverseDoraAvun // our class
{
    public static void main(String args[])
    {
        String repeat = "Y"; //to check validity to repeat the main method.
        while(repeat.equals("Y")) //while repeat parameter is still true, loop the code
        {
            Scanner scan = new Scanner(System.in);  // Create a Scanner object
            System.out.println("Enter name");


            String userName = scan.nextLine();  // Read user input

            int i = userName.length() - 1; //i is the index integer to get char values in the method.
                                           //set to last letter of string by default.
            System.out.println("Entered String: " + userName); //print out regular string
            System.out.print("Reversed String: ");             //print out reversed string
            printCharsReverse(userName, i);                    // call the method with userName and index i.

            Scanner yesOrNo = new Scanner(System.in);  // Create a new Scanner object
            System.out.println("\nTry Again? Y/N: ");  // Create new line for formatting.
            repeat = yesOrNo.nextLine();               // Setting the repeat parameter to user input.
        }
    }

    static void printCharsReverse(String str, int count) //our method to recursively call itself and create
                                                         //a reversed string.
    {
        if (count >= 0) // if index is still a valid location in the string
        {
            System.out.print(str.charAt(count));  // Output the character at 'count' location which is the last
                                                  // letter of the string
            count--;                              // decrement count location.
            printCharsReverse(str, count);        // recursively call this method until the string finishes.
        }
    }
}


