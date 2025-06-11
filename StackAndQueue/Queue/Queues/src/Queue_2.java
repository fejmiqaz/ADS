import java.util.*;

public class Queue_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        Queue<Integer> q1 = new LinkedList<Integer>();
        while(n-- > 0){
            Integer tmp = Integer.parseInt(sc.next());
            q1.add(tmp);
        }

        Queue<Integer> q2 = new LinkedList<Integer>();
        while(!q1.isEmpty()){
            Integer tmp = q1.peek();
            if(q2.isEmpty()){
                q2.add(tmp);
            }else{
                Integer tmp2 = q2.peek();
                if (tmp > tmp2){
                    q2.add(tmp);
                }
            }
            q1.poll();
        }
        System.out.println(q2);

    }
}
