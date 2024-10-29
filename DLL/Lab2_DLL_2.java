package Labs;

/* You are given a doubly linked list of integers. Additionally, there is one more natural number k. You need to replace
* the last k elements of the list to the beginning of the list, in the same order.
* Input:
* 5
* 1 2 3 4 5
* 2
* Output:
* 1<->2<->3<->4<->5
* 4<->5<->1<->2<->3
* */

import java.util.Scanner;

public class Lab2_DLL_2 {
    public static void main(String[] args) {
        DLL<Integer> list = new DLL<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            list.insertLast(sc.nextInt());
        }
        int k = sc.nextInt();
        System.out.println(list);
        DLLNode<Integer> current = list.getFirst();
        DLLNode<Integer> last = list.getLast();
        while((current!=last) && (current.pred!=last)){
            while((last!=current) && (k != 0)){
                list.insertBefore(last.element,current);
                k--;
                last = last.pred;
                current = current.pred;
                list.deleteLast();
            }
            current = current.succ;
            last = last.pred;
        }
        System.out.println(list);

    }
}
