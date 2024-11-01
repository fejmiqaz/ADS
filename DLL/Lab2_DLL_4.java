import java.util.Scanner;

/* You are given a doubly-linked list of integers. Additionally, there is one more natural number k. You need to rotate the elements of the list k times to the left.

Input: The first number in the input is the number of integers in the list - N, then in the next line the elements are given, separated by spaces. Then, in the last line, the natural number k is given.

Output: The list before and after the transformation
 Example:
 Input:
 5
 1 2 3 4 5
 2
 Output:
 1<->2<->3<->4<->5
 3<->4<->5<->1<->2
 
 */

public class Lab2_DLL_4 {
    public static void main(String[] args) {
        DLL<Integer> list = new DLL<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        int k = sc.nextInt();
        System.out.println(list);
        DLLNode<Integer> current = list.getFirst();
        while(current!=null && k>0) {
            list.insertLast(current.element);
            list.deleteFirst();
            current = current.succ;
            k--;
        }
        System.out.println(list);
    }
}
