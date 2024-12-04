package Labs.StackAndQueue.Stack;

/* Find the maximum and minimum elements in a stack.
* Example input:
* 5
* 1 2 3 4 5
* Output: 5 1
* */

import java.util.Stack;
import java.util.Scanner;

public class Lab5_Stack_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            stack.push(sc.nextInt());
        }
        int max = 0;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < stack.size(); i++){
            if(stack.get(i) > max){
                max = stack.get(i);
            }
            if(stack.get(i) < min){
                min = stack.get(i);
            }
        }
        System.out.println(max + " " + min);
    }
}
