package Labs.StackAndQueue.Stack;

import java.util.Stack;
import java.util.Scanner;

/* Write a Java program that will reverse the elements of a stack.
* Input:
* 5
* 1 2 3 4 5
* Output: 5 4 3 2 1 */

public class Lab5_Stack_7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }
        Stack<Integer> stack2 = new Stack<>();
        for(int i = n-1; i >= 0; i--) {
            stack2.push(stack.pop());
        }
        System.out.println(stack2);
    }
}
