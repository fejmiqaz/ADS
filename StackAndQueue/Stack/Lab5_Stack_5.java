package Labs.StackAndQueue.Stack;

import java.util.Stack;
import java.util.Scanner;

/* Write a Java program to delete all elements from a stack. */

public class Lab5_Stack_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        while(sc.hasNextInt()){
            stack.push(sc.nextInt());
        }
        while(!stack.isEmpty()){
            stack.remove(stack.pop());
        }
        if(stack.isEmpty()){
            System.out.println("Empty Stack");
        }else{
            System.out.println(stack);
        }
    }
}
