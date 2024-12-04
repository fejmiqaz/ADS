package Labs.StackAndQueue.Stack;

import java.util.Stack;
import java.util.Scanner;

/* HTML Tag validations. You need to handle both opening (<tag>) and closing (</tag>) tags. Check if they match and if
* they are properly formatted.
*  */

public class Lab5_Stack_2 {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();
        Scanner sc = new Scanner(System.in);
        String s = "";
        while(true){
            s = sc.nextLine();
            if(s.equals("x")){
                return;
            }
            if(s.startsWith("<") && s.endsWith(">")){
                String tag = s.substring(1, s.length()-1).toLowerCase();
                if(!tag.startsWith("/")){
                    stack.push(tag);
                }else{
                    String temp = tag.substring(1);
                    if(stack.isEmpty()){
                        System.out.println("Invalid");
                        return;
                    }
                    String last = stack.pop();
                    if(last.equals(temp)){
                        System.out.println("Valid");
                        return;
                    }else{
                        System.out.println("Invalid");
                        return;
                    }
                }
            }else{
                System.out.println("Invalid");
                return;
            }
        }
    }
}
