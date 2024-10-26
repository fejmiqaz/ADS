/* You are given a single linked list with String nodes. Additionally, you are given one more integer L. You need to delete every node from the list that contains a String with less than L characters.

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
Cloud
*/
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
