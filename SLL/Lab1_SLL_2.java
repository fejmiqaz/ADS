package Labs;

import java.util.Scanner;

public class Lab1_SLL_2<E> {
    public static void main(String[] args) {
        SLL<String> list = new SLL<String>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            list.insertLast(sc.next());
        }
        int L = sc.nextInt();
        System.out.println(list);
        SLLNode<String> tmp = list.getFirst();
        while(tmp != null){
            if(tmp.element.length() < L){
                list.delete(tmp);
            }
            tmp = tmp.succ;
        }
        System.out.println(list);
    }
}
