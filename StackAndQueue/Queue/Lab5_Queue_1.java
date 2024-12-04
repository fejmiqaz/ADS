package Labs.StackAndQueue.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* Write a Java program to count all the elements of a Queue. */

public class Lab5_Queue_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();
        String input = "";
        while(true){
            input = sc.nextLine();
            if(input.equals("end")){
                break;
            }
            queue.add(input);
        }
        int cnt = 0;
        while(!queue.isEmpty()) {
            queue.poll();
            cnt++;
        }
        System.out.println(cnt);
    }
}
