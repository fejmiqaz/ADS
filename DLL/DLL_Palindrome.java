package Labs;
import java.util.Scanner;
public class DLL_Palindrome {
    public static void main(String[] args) {
        DLL<Integer> list = new DLL<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        DLLNode<Integer> current = list.getFirst();
        DLLNode<Integer> last = list.getLast();
        boolean flag = true;
        while((current!=last) && (current.pred!=last)){
            if(!current.element.equals(last.element)){
                flag = false;
            }
            current=current.succ;
            last = last.pred;
        }
        if(flag){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }
    }
}
