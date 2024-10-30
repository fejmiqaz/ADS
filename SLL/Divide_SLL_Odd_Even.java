/* For a single linked list, you need to create another 2 lists such that one of them will have even elements from the original list and the other one will hold the odd elements from the original list.
Input:
10
1 2 3 4 5 6 7 8 9 10
Output:
2->4->6->8->10
1->3->5->7->9
*/

import java.util.Scanner;

public class Divide_SLL_Odd_Even {
    public static void main(String[] args) {
        SLL<Integer> list = new SLL<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.insertLast(sc.nextInt());
        }
        SLLNode<Integer> current = list.getFirst();
        SLL<Integer> even = new SLL<Integer>();
        SLL<Integer> odd = new SLL<Integer>();
        while(current!=null){
            if(current.element % 2 == 0){
                even.insertLast(current.element);
            }else{
                odd.insertLast(current.element);
            }
            current = current.succ;
        }
        System.out.println(even);
        System.out.println(odd);
    }
}
