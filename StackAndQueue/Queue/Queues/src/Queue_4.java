import java.util.*;

class SStudent {
    String name, surname;
    Integer f1,f2,f3;

    public SStudent(String name, String surname, Integer f1, Integer f2, Integer f3) {
        this.name = name;
        this.surname = surname;
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
    }

    @Override
    public String toString() {
        return  name + " " + surname ;
    }
}

public class Queue_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        sc.nextLine();
        Queue<SStudent> submit_receive_document = new LinkedList<>();
        Queue<SStudent> receive_index = new LinkedList<>();
        Queue<SStudent> receive_high_school_documents = new LinkedList<>();
        while(n-- > 0){
            String name = sc.next();
            String surname = sc.next();
            int f1 = sc.nextInt();
            int f2 = sc.nextInt();
            int f3 = sc.nextInt();
            SStudent student = new SStudent(name,surname,f1,f2,f3);
            if(f1 == 1){
                submit_receive_document.add(student);
            }else if (f2 == 1){
                receive_index.add(student);
            }else if (f3 == 1){
                receive_high_school_documents.add(student);
            }
        }

        while(!submit_receive_document.isEmpty() || !receive_index.isEmpty() || !receive_high_school_documents.isEmpty()){
            if (!submit_receive_document.isEmpty()){
                SStudent tmp = submit_receive_document.poll();
                if(tmp.f2 == 1){
                    receive_index.add(tmp);
                }else if (tmp.f3 == 1){
                    receive_high_school_documents.add(tmp);
                }else{
                    System.out.println(tmp);
                }
            }
            if (!receive_index.isEmpty()){
                SStudent tmp = receive_index.poll();
                if(tmp.f3 == 1){
                    receive_high_school_documents.add(tmp);
                }else{
                    System.out.println(tmp);
                }
            }
            if (!receive_high_school_documents.isEmpty()){
                SStudent tmp = receive_high_school_documents.poll();
                System.out.println(tmp);
            }
        }
    }
}
