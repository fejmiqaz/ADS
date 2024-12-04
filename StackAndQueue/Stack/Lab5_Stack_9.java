package Labs.StackAndQueue.Stack;

import java.util.Stack;
import java.util.Scanner;

/* Write a Java program that will rotate a Stack K-times from the right. and then M times to the left.
* Example input:
* 5
* 1 2 3 4 5
* 2
* 1
* Output:
* [4, 5, 1, 2, 3]
* [5, 1, 2, 3, 4] */

public class Lab5_Stack_9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }
        int k = sc.nextInt();
        int m = sc.nextInt();

        while(k>0){
            if (!stack.isEmpty()) {
                int top = stack.pop();

                Stack<Integer> temp = new Stack<>();

                while(!stack.isEmpty()) {
                    temp.push(stack.pop());
                }
                stack.push(top);

                while(!temp.isEmpty()) {
                    stack.push(temp.pop());
                }
            }
            k--;
        }
        System.out.println(stack);
        while(m>0){
            Stack<Integer> temp = new Stack<>();
            while (!stack.isEmpty()) {
                temp.push(stack.pop());
            }
            int bottomEl = temp.pop();
            while(!temp.isEmpty()) {
                stack.push(temp.pop());
            }
            stack.push(bottomEl);
            m--;
        }

        System.out.println(stack);
    }
}
