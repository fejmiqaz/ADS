import java.util.Scanner;
import java.util.Stack;

public class Stack_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();
        boolean check = true;
        int n = sc.nextInt();
        sc.nextLine();
        while(n-- > 0){
            String input = sc.nextLine();

            if(input.endsWith("#")) {
                if (stack.isEmpty()) {
                    stack.push(input);
                }else {
                    String top = stack.peek();
                    if(top.charAt(top.length() - 2) < input.charAt(input.length() - 2)){
                        stack.push(input);
                    }else{
                        check = false;
                        break;
                    }
                }
            }else if (input.startsWith("#")) {

                if(stack.empty()){
                    check = false;
                    break;
                }

                String top = stack.peek();
                char topLast = top.charAt(top.length() - 2);
                char inputLast = input.charAt(input.length() - 1);

                if(topLast == 'y' && inputLast == 'y'){
                    stack.pop();
                }else if(topLast == inputLast){
                    stack.pop();
                }else{
                    check = false;
                    break;
                }
            }
        }
        if(check && stack.isEmpty()){
            System.out.println("Valid");
        }else {
            System.out.println("Invalid");
        }
    }
}
