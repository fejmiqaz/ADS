/* Given a doubly linked list whose nodes each contain one natural number. The list should be divided into two resulting lists,
 i.e. the first list should contain all nodes that contain numbers less than or equal to the average of the list, and the second
 should contain all nodes that contain numbers greater than the average of the list. The nodes in the resulting lists are added
 in the reverse order of their appearance in the given list (i.e., first, the last node in the input list is considered and added
 to the corresponding resulting list, then the penultimate one, etc.).

The first line of the input gives the number of nodes in the list, and the second line gives the numbers that make up the
 nodes in order in the list. The first line of the output should print the nodes in order from the first resulting list
 (numbers less than or equal to the average of the list), and the second line from the second (numbers greater than the average of the list).

Class name (for Java): PodeliListaProsek

Partial solution: The task is considered partially solved if 7 test examples are passed.

Note: When implementing the tasks, the given structures MUST be used, and not auxiliary structures such as arrays or the like.
Sample input
5
4 2 1 5 3
Sample output
3 1 2
5 4 */

import java.util.Scanner;
public class DivideListAvg {
    public static void main(String[] args) {
     DLL<Integer> list = new DLL<Integer>();
     Scanner sc = new Scanner(System.in);
     int n = sc.nextInt();
     for(int i = 0; i < n; i++) {
         list.insertLast(sc.nextInt());
     }
     sc.close();
     DLLNode<Integer> current = list.getFirst();
     int sum = 0, cnt = 0;
     while(current != null) {
         sum += current.element;
         cnt++;
         current = current.succ;
     }
     double avg = (double) sum / cnt;
     System.out.println(avg);
     current = list.getFirst();
     DLL<Integer> lessThanAvg = new DLL<Integer>();
     DLL<Integer> greaterThanAvg = new DLL<Integer>();
     while(current!=null){
         if( (double) current.element <= avg){
             lessThanAvg.insertLast(current.element);
         }else if ( (double) current.element > avg){
             greaterThanAvg.insertLast(current.element);
         }
         current = current.succ;
     }
     lessThanAvg.mirror();
     greaterThanAvg.mirror();
     System.out.println(lessThanAvg);
     System.out.println(greaterThanAvg);
    }
}
