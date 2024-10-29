/* For a given doubly-linked list with N integers, you need to find the number of elements such that the average of all elements before it is bigger than the average of all elements after it in the list. 

Input: The first number in the input is the number of integers in the list N, then in the next line the elements are given, separated by spaces:
5
1 2 3 4 5

Output: The number of elements that satisfy the condition:
0
*/
import java.util.Scanner;

public class Lab2_DLL {
    public static void main(String[] args) {
        DLL<Integer> list = new DLL<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            list.insertLast(sc.nextInt());
        }

        DLLNode<Integer> tmp = list.getFirst();
        if(tmp == null){ System.out.println("Empty list"); }
        
        int cnt = -1;
        while(tmp != null){
            int sum = 0, count = 0;
            double avgLeft = 0.0, avgRight = 0.0;
            DLLNode<Integer> left = tmp.pred;
            while(left!=null){
                sum += left.element;
                count++;
                left = left.pred;
            }
            if(count > 0){
                avgLeft = (double)sum/count;
            }
            sum = 0;
            count = 0;
            DLLNode<Integer> right = tmp.succ;
            while(right!=null){
                sum += right.element;
                count++;
                right = right.succ;
            }
            if(count > 0){
                avgRight = (double)sum/count;
            }
            if(avgLeft > avgRight){
                cnt++;
            }
            tmp = tmp.succ;
        }
        System.out.println(cnt);
    }
}
