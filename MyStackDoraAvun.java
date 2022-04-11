// Name:		Dora Avun
// Program Number: (#1) MyStackDoraAvun
// IDE: 		IntelliJ IDEA (2021.3.1)
// Declare functions for our stack.

import java.util.EmptyStackException;
import java.util.Stack;

public class MyStackDoraAvun<E>
{
    Stack<E> stack = new Stack<E>();

    public Boolean isEmpty()
    {
        return (stack.size() == 0);
    }

    public int size()
    {
        return stack.size();
    }

    public E peek()
    {
        if (stack.isEmpty())
            throw new EmptyStackException();
        else
            return stack.peek();
    }

    public E pop()
    {
        if (stack.isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            E top = stack.peek();
            stack.pop();
            return top;
        }
    }

    public void push(E element)
    {
        stack.push(element);
    }

    public String toString()
    {
        if (!stack.isEmpty())
        {
            String str = "Items are: ";
            for (E item : stack)
            {
                str = str + item.toString() + " ";
            }
            return str;
        }
        else
            throw new EmptyStackException();
    }

}
