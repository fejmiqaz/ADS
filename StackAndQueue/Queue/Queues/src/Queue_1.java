import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Student {
    public String name;
    public String surname;
    public Integer q1;
    public Integer q2;
    public Integer q3;

    public Student(String name, String surname, Integer q1, Integer q2, Integer q3) {
        this.name = name;
        this.surname = surname;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
}

public class Queue_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        sc.nextLine();

        Queue<Student> q1 = new LinkedList<Student>();
        Queue<Student> q2 = new LinkedList<Student>();
        Queue<Student> q3 = new LinkedList<Student>();
        while(n-- > 0){
            String name = sc.next();
            String surname = sc.next();
            int f1 = sc.nextInt();
            int f2 = sc.nextInt();
            int f3 = sc.nextInt();

            Student student = new Student(name,surname,f1,f2,f3);

            if(student.q1 == 1){
                q1.add(student);
            }else if (student.q2 == 1){
                q2.add(student);
            }else if (student.q3 == 1){
                q3.add(student);
            }

        }
        while(!q1.isEmpty() || !q2.isEmpty() || !q3.isEmpty()){
            Integer counter = 2;
            while(!q1.isEmpty() && counter-- > 0){
                Student tmp = q1.poll();
                if(tmp.q2 == 1){
                    q2.add(tmp);
                }else if(tmp.q3 == 1){
                    q3.add(tmp);
                }else{
                    System.out.println(tmp);
                }
            }
            if (!q2.isEmpty()){
                Student tmp = q2.poll();
                if(tmp.q3 == 1) {
                    q3.add(tmp);
                }else{
                    System.out.println(tmp);
                }
            }
            counter = 2;
            while(!q3.isEmpty() && counter-- > 0){
                Student tmp = q3.poll();
                System.out.println(tmp);
            }
        }
    }
}
