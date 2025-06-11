import java.util.Scanner;
import java.util.Stack;

public class Stack_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();
        Integer result = 0;
        while (true) {
            String input = sc.nextLine();

            if(input.charAt(0) == 'x'){
                break;
            }

            if((input.charAt(0) != '+') && (input.charAt(0) != '*')){
                stack.push(input);
            }else{
                while(!stack.isEmpty()){
                    if(input.charAt(0) == '+'){
                        result += Integer.parseInt(stack.peek());
                        stack.pop();
                    }else if (input.charAt(0) == '*'){
                        result *= Integer.parseInt(stack.peek());
                        stack.pop();
                    }
                }
            }

        }
        System.out.println(result);
    }
}
