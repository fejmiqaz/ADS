package Labs;

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
