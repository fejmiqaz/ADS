import java.util.*;

class Student_1 {
    String name, surname;
    Integer q1,q2,q3;

    public Student_1(String name, String surname, Integer q1, Integer q2, Integer q3) {
        this.name = name;
        this.surname = surname;
        this.q1 = q1;
        this.q2 = q2;
        this.q3 = q3;
    }

    @Override
    public String toString() {
        return name + " " +  surname;
    }
}

public class Queue_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        sc.nextLine();
        Queue<Student_1> science = new LinkedList<>();
        Queue<Student_1> scienceFiction = new LinkedList<>();
        Queue<Student_1> history = new LinkedList<>();
        for (int i = 0; i < n; i++){
            String name = sc.next();
            String surname = sc.next();
            int f1 = sc.nextInt();
            int f2 = sc.nextInt();
            int f3 = sc.nextInt();
            Student_1 student = new Student_1(name,surname,f1,f2,f3);
            if(f1 == 1){
                science.add(student);
            }else if (f2 == 1){
                scienceFiction.add(student);
            }else if (f3 == 1){
                history.add(student);
            }
        }
        while(!science.isEmpty()){
            Student_1 tmp = science.poll();
            if(tmp.q2 == 1){
                scienceFiction.add(tmp);
            }else if(tmp.q3 == 1){
                history.add(tmp);
            }else{
                System.out.println(tmp);
            }
        }
        while(!scienceFiction.isEmpty()){
            Student_1 tmp = scienceFiction.poll();
            if(tmp.q3 == 1){
                history.add(tmp);
            }else{
                System.out.println(tmp);
            }
        }
        while(!history.isEmpty()){
            Student_1 tmp = history.poll();
            System.out.println(tmp);
        }
    }
}
