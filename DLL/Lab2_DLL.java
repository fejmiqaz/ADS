package Labs;

import java.util.Scanner;

public class Lab2_DLL {
    public static void main(String[] args) {
        DLL<Integer> list = new DLL<Integer>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++){
            list.insertLast(sc.nextInt());
        }

        // ^^^ input of the List

        DLLNode<Integer> current = list.getFirst();

        if(current == null){ // check if the list is empty or not
            System.out.println("Empty List");
        }
        int cnt = -1; // set a counter for the elements that satisfy the condition, starting from -1 bcs we don't want the first elements of both of the sides

        while(current!=null){ // iterate through the list
            int sumLeft = 0, cntLeft = 0; // declare the sum and counter for the left side
            DLLNode<Integer> left = list.getFirst(); // declare a left node
            while(left!=current){ // iterate from the right
                sumLeft += left.element; // sum the elements
                cntLeft++; // count the elements
                left = left.succ; // move backward
            }
            double avgLeft = 0.0; // declare average for the left side
            if(cntLeft > 0){
                avgLeft = (double)sumLeft / cntLeft; // do the avg
            }
            int sumRight = 0, cntRight = 0; // same for the right side
            DLLNode<Integer> right = current.succ; // it st
            while(right!=null){ // iterate from left
                sumRight += right.element; // sum those elements
                cntRight++; // cound them
                right = right.succ; // move forward
            }

            double avgRight = 0.0; // declare the avg for the right side
            if(cntRight > 0){
                avgRight = (double)sumRight / cntRight; // get the avg
            }
            if(avgLeft > avgRight){
                cnt++; // count how many elements satisfy the condition
            }

            current = current.succ; // continue
        }
        System.out.println(cnt);
    }
}
