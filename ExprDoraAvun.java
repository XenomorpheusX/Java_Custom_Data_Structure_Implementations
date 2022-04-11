// Name:		Dora Avun
// Program Number: (#3) ExprDoraAvun
// IDE: 		IntelliJ IDEA (2021.3.1)
// Convert stack from MyStackDoraAvun from infix notation to postfix, and evaluate.
import java.util.Scanner;  // Import the Scanner class

public class ExprDoraAvun
{
    static int Priority(char ch)
    { //SETTING UP THE PRIORITIES FOR THE OPERATORS
        switch (ch)
        {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String infixToPostfix(String infix)
    {
        if (infix == null) //if string is empty, exit
        {
            System.exit(-1);
        }
        String result = new String(""); //String to output
        MyStackDoraAvun<Character> stack = new MyStackDoraAvun<Character>(); //initialize stack

        for (int i = 0; i<infix.length(); ++i) //for each word of the infix, loop
        {
            char c = infix.charAt(i); //set current character
            if (c == '(') //if c is a opening paranthesis, add to stack
                stack.push(c);

            else if (c == ')') //if it is a closing paranthesis, iterate and pop and add to result until stack
            {                  //is empty
                while (!stack.isEmpty() && (stack.peek() != '('))
                {
                    result += stack.pop();
                }
            }
            else // operator
            {
                while (!stack.isEmpty() && (Priority(c) <= Priority(stack.peek()))) //manage priority
                {
                    result += stack.pop(); //add popped value to result
                }
                stack.push(c); //push c in stack
            }
        }

        while (!stack.isEmpty())//pop operators
        {
            if(stack.peek() == '(')
                return "Invalid Expression";
            result += stack.pop();
        }
        return result;
    }

    public static double postfixEval(String infix)
    {
        if (infix == null) //if string is null, exit
        {
            System.exit(-1);
        }
        MyStackDoraAvun<Double> stack = new MyStackDoraAvun<Double>(); //new stack

        for (char c: infix.toCharArray()) //foreach element in string
        {
            if (Character.isDigit(c)) //if operand push into stack
            {
                stack.push((double) c - '0');
            }

            else // if the current character is an operator
            {
                // remove the top two elements from the stack
                double x = stack.pop();
                double y = stack.pop();

                if (c == '+') //evaluate and push for each case
                {
                    stack.push(x + y);
                }
                else if (c == '-')
                {
                    stack.push(x - y);
                }
                else if (c == '*')
                {
                    stack.push(x * y);
                }
                else if (c == '/')
                {
                    stack.push(x / y);
                }
            }
        }
        return stack.pop(); //return the last element which is the result
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);  // Create a Scanner object
        Boolean quit = false;
        while (quit == false)
        {
            System.out.println("Insert an infix to convert to postfix and calculate: ");
            String infix = scanner.nextLine();
            String postfix = infixToPostfix(infix);
            System.out.println("Postfix form is: " + postfix);
            System.out.println("Calculated result is: " + postfixEval(postfix));

            System.out.println("Do you want to quit (Y/N)?");
            String wantQuit = scanner.nextLine();

            if (wantQuit == "Y")
            {
                quit = true;
            }
        }

    }

}
