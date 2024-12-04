package Labs.StackAndQueue.Stack;

/* Write a Java program to count all stack elements, their sum and their average. */

import java.util.Stack;
import java.util.Scanner;

public class Lab5_Stack_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        while (sc.hasNextInt()) {
            stack.push(sc.nextInt());
        }
        int cnt = 0;
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
            cnt++;
        }
        System.out.println("Elements: " + cnt + " Sum: " + sum + " Average:" + sum/cnt);
    }
}
