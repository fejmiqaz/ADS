import java.util.Scanner;
import java.util.Stack;

public class Stack_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> stack = new Stack<String>();
        boolean check = true;
        while(true) {
            String input = sc.nextLine();

            if (input.equals("x")) {
                break;
            }

            if (input.startsWith("func")) {
                stack.push(input);
            } else if (input.startsWith("end")) {
                if (!stack.isEmpty()) {
                    String top = stack.peek();
                    Character topLastElement = top.charAt(top.length() - 1);
                    Character inputLastElement = input.charAt(input.length() - 1);
                    if (topLastElement.equals(inputLastElement)) {
                        stack.pop();
                    }
                }else{
                    check = false;
                }
            }
        }
        if (check  && stack.isEmpty()){
            System.out.println("Valid");
        }else{
            System.out.println("Invalid");
        }
    }
}
