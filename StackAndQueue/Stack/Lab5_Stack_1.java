package Labs.StackAndQueue.Stack;

import java.util.Stack;
import java.util.Scanner;

/* We are given code in a modified programming language is given, where functions are represented by an opening and
closing tag ("functionName" and "endfunctionName"). Your task is to determine whether the given code is valid.

Example of valid code:
func1
func2
endfunc2
func3
endfunc3
endfunc1

Example of invalid code (missing closing tag for func3):
func1
func2
endfunc2
func3
endfunc1

Input: Code in a modified programming language, where each tag is written in a new line. Tags are entered until "x" is entered.
Output: "Valid" if the code is valid, "Invalid" if the code is not valid. */

public class Lab5_Stack_1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<>();
        String s = "";
        while(true) {
            s = sc.nextLine();
            if (s.equals("x")) {
                break;
            }
           if(s.startsWith("func")){
               stack.push(s);
           }else if (s.startsWith("endfunc")){
               if(stack.isEmpty()){
                   System.out.println("Invalid");
                   return;
               }
               String last = stack.pop();
               String expected = "end" + last;
               if(!s.equals(expected)){
                   System.out.println("Invalid");
                   return;
               }
           }else{
               System.out.println("Invalid");
               return;
           }
        }
        if(stack.isEmpty()){
            System.out.println("Valid");
        }else {
            System.out.println("Invalid");
        }
    }
}
