import java.util.Scanner;
import java.util.Stack;

public class Stack_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();
        boolean check = true;
        while(true){
            String input = sc.nextLine();
            if (input.equals("x")){
                break;
            }

            if(!input.startsWith("</")){
                if(stack.isEmpty()){
                    stack.push(input);
                }else{
                    String top = stack.peek();
                    if((top.equals("<html>")) && ((!input.equals("body") || (!input.equals("head"))))){
                        break;
                    }else{
                        stack.push(input);
                    }
                }
            }else {
                String top = stack.peek();
                String name = input.replace("<", "");
            }
        }

    }
}
