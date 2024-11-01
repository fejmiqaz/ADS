package Labs;

import java.util.Scanner;



/*
Given a doubly linked list of integers. In addition, another integer M and a natural number k are also given.
 We need to find the first occurrence of M in the list and move that number k places to the left.

Input: In the first line of the input, the number of elements in the list is given - N, then in the next line,
the elements themselves, separated by a space. Finally, the whole number M and the natural number k are given in the last two lines.

Output: The list before and after the change should be printed on the output.

Input:
5
1 2 3 4 5
3
2
Output:
1<->2<->3<->4<->5
3<->1<->2<->4<->5

Input:
9
5 3 8 6 2 4 1 9 7
4
7
Output:
5<->3<->8<->6<->2<->4<->1<->9<->7
5<->3<->8<->6<->2<->1<->9<->4<->7

*/

public class Lab2_DLL_3 {
    public static void main(String[] args) {
        DLL<Integer> list = new DLL<Integer>();
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for(int i = 0; i < m; i++){
            list.insertLast(sc.nextInt());
        }
        int n = sc.nextInt();
        int k = sc.nextInt();
        DLLNode<Integer> current = list.getFirst();
        System.out.println(list);
        DLLNode<Integer> target = null;
        while(current != null){
            if(current.element.equals(n)){
                target = current;
                break;
            }
            current=current.succ;
        }
        while(k>0 && target!=null){
            list.insertBefore(target.element, target.pred);
            target = target.pred;
            list.delete(target.succ);
            k--;
        }
        System.out.println(list);

//        while(current != null){
//            DLLNode<Integer> elem = null;
//            if(current.element == n){
//                elem = current;
//                break;
//            }
//            while(k>0){
//                elem = current.pred;
//                current.pred = current;
//                k--;
//            }
//
//            current = current.succ;
//        }
//
//        System.out.println(list);


    }
}

