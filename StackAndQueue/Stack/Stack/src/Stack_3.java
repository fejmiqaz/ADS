import java.util.*;
import java.util.Stack;
public class Stack_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();
        boolean check = true;
        int n = sc.nextInt();
        sc.nextLine();
        while(n-- > 0){
            String input = sc.nextLine();
            if(input.charAt(1) == 'b'){
                if(stack.empty()){
                    stack.push(input);
                }else{
                    String top = stack.peek();
                    if(top.length() < input.length()){
                        stack.push(input);
                    }else{
                        check = false;
                        break;
                    }
                }
            }else {
                if (stack.empty()){
                    check = false;
                    break;
                }
                String top = stack.peek();
                if((top.length()-2) == input.length()){
                    stack.pop();
                }
            }
        }
        if(check && stack.empty()){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }
    }
}
