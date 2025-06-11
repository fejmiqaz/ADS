import java.util.Scanner;
import java.util.Stack;

public class Stack_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();
        int n = sc.nextInt();
        boolean check = true;
        sc.nextLine();
        while(n-- > 0){
            String input = sc.nextLine();
            if(input.startsWith("begin")){
                if(stack.isEmpty()){
                    stack.push(input);
                }else{
                    String top = stack.peek();
                    if(top.endsWith("{theorem}") || top.endsWith("{equation}")){
                        stack.push(input);
                    }else{
                        check = false;
                        break;
                    }
                }
            }else{
                String top = stack.peek();
                if((top.length()-2) == (input.length())){
                    stack.pop();
                }
            }
        }

        if(check && stack.isEmpty()){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }
    }
}
