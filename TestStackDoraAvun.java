// Name:		Dora Avun
// Program Number: (#2) TestStackDoraAvun
// IDE: 		IntelliJ IDEA (2021.3.1)
// Main user interface to control our stack - MyStackDoraAvun.java

import java.util.Scanner;  // Import the Scanner class

public class TestStackDoraAvun
{
    public static void main(String[] args)
    {
        MyStackDoraAvun<String> stack = new MyStackDoraAvun<String>();

        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        Boolean quit = false;
        while (quit == false)
        {
            System.out.println("-----MAIN MENU-----");
            System.out.println("0 - Exit Program");
            System.out.println("1 – Push");
            System.out.println("2 – Pop");
            System.out.println("3 – Peek (Top)");
            System.out.println("4 - Size");
            System.out.println("5 – Is Empty?");
            System.out.println("6 – Print Stack");
            System.out.println("Choose menu:");

            String input = scanner.nextLine();
            switch (input)
            {
                case "0":
                    quit = true;
                    break;
                case "1":
                    System.out.println("Enter element to push in: ");
                    String element = scanner.nextLine();
                    stack.push(element);
                    break;
                case "2":
                    System.out.println("Popped: " + stack.pop()); //actually pops and returns at the same time.
                    break;
                case "3":
                    System.out.println("Top Element is: " + stack.peek());
                    break;
                case "4":
                    System.out.println("Size is: " + stack.size());
                    break;
                case "5":
                    System.out.println("Is the stack empty?: " + stack.isEmpty());
                    break;
                case "6":
                    System.out.println(stack.toString());
                    break;
            }
        }
    }
}
