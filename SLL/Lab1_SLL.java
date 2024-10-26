package Labs;

import java.util.Scanner;

public class Lab1_SLL<E> {
    public static void main(String[] args) {
        SLL<String> list = new SLL<String>();
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        for (int i = 0; i < n; i++) {
            list.insertLast(input.next());
        }
        int L = input.nextInt();
        System.out.println(list);
        SLLNode<String> tmp = list.getFirst();
        while(tmp != null) {

            if(tmp.element.length() > L){
                list.insertBefore("Outlier",tmp);
            }
            tmp = tmp.succ;
        }
        System.out.println(list);
    }

}
