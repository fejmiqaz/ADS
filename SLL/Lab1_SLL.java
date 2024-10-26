
/* You are given a single linked list with String nodes. Additionally, you are given one more integer L. You need to insert a new node with value "Outlier" before each node that contains a String with more than L characters in the list.

Input: In the first line from the input the number of elements in the list is given - N, and then in the next N lines the elements themselves. In the last line, the integer L is given.

Output: The list before and after the transformation
EXAMPLE:
INPUT:
3
Sky
Blue
Cloud
5

OUTPUT:
Sky->Blue->Cloud
Sky->Blue->Cloud

*/
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
