package Labs.DLL;

/* You are given a list that has another list inside. Get the sum of the elements.
* Input: Integer n that tells us how many lists there are. Integer m that that tells us how many elements there are in each list.
* Output: The the sum of the sub-lists. */

import java.util.Scanner;

public class DLL_SumListOfLists {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        DLL<DLL<Integer>> list1= new DLL<DLL<Integer>>();
        for(int i = 0; i < n; i++){
            DLL<Integer> list2 = new DLL<Integer>();
            for(int j = 0; j < n; j++){
                int value = sc.nextInt();
                list2.insertLast(value);
            }
            list1.insertLast(list2);
        }
        DLLNode<DLL<Integer>> curr1 = list1.getFirst();
        int sum = 0;
        while(curr1 != null){
            DLLNode<Integer> curr2 = curr1.element.getFirst();
            while(curr2 != null){
                sum += curr2.element;
                curr2 = curr2.succ;
            }
            curr1 = curr1.succ;
        }
        System.out.println(sum);
    }
}
