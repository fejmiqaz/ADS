package Labs.StackAndQueue.Stack;

import java.util.Stack;
import java.util.Scanner;

/* Write a Java program to implement a stack that checks if a given element is present or not in the stack.
* Input:
* 5
* 5 4 3 2 1
* 2
* Output: Yes at index: 3 */

public class Lab5_Stack_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int m = sc.nextInt();
        for(int i = 0; i < m; i++) {
            stack.push(sc.nextInt());
        }
        int n = sc.nextInt();
        boolean flag = false;
        int idx = 0;
        if(!stack.isEmpty()){
            for(int i = 0; i < m; i++){
                if(stack.get(i) == n){
                    flag = true;
                    idx = i;
                    break;
                }
            }
        }
        if(flag){
            System.out.println("Yes at index: " + idx);
        }else{
            System.out.println("No");
        }
    }
}
