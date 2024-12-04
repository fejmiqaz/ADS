package Labs.StackAndQueue.Stack;

import java.util.Stack;
import java.util.Scanner;

/* Write a Java program to get the last and the first element of a Stack.
* Input:
* 5
* 1 2 3 4 5
* Output: 5 1 */

public class Lab5_Stack_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }
        int last = stack.getLast();
        int first = stack.getFirst();
        System.out.println(last + " " + first);
    }
}
