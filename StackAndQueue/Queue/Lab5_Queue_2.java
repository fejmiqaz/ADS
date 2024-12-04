package Labs.StackAndQueue.Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/* Write a Java program to get the last element of a Queue. */

public class Lab5_Queue_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<String> queue = new LinkedList<>();
        String s = "";
        while(true){
            s = sc.nextLine();
            if(s.equals("end")) break;
            queue.offer(s);
        }
        String lastEl = "";
        while(!queue.isEmpty()){
            lastEl = queue.remove();
        }
        System.out.println(lastEl);
    }
}
