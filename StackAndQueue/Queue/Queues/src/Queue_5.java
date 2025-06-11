import java.util.*;

class Schooler {
    String name, surname;
    Integer f1,f2,f3;

    public Schooler(String name, String surname, Integer f1, Integer f2, Integer f3) {
        this.name = name;
        this.surname = surname;
        this.f1 = f1;
        this.f2 = f2;
        this.f3 = f3;
    }

    @Override
    public String toString() {
        return  name + " " + surname;
    }
}

public class Queue_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = sc.nextInt();
        sc.nextLine();
        Queue<Schooler> submit_receive_document = new LinkedList<>();
        Queue<Schooler> receive_index = new LinkedList<>();
        Queue<Schooler> receive_high_school_documents = new LinkedList<>();
        while(n-- > 0){
            String name = sc.next();
            String surname = sc.next();
            int f1 = sc.nextInt();
            int f2 = sc.nextInt();
            int f3 = sc.nextInt();
            Schooler schooler = new Schooler(name,surname,f1,f2,f3);
            if(schooler.f1 == 1){
                submit_receive_document.add(schooler);
            }else if (schooler.f2 == 1){
                receive_index.add(schooler);
            }else if (schooler.f3 == 1) {
                receive_high_school_documents.add(schooler);
            }
        }
        while(!submit_receive_document.isEmpty() || !receive_index.isEmpty() || !receive_high_school_documents.isEmpty()){
            for (int i = 0; i < 2; i++){
                if(!submit_receive_document.isEmpty()){
                    Schooler tmp = submit_receive_document.poll();
                    if(tmp.f2 == 1){
                        receive_index.add(tmp);
                    }else if (tmp.f3 == 1){
                        receive_high_school_documents.add(tmp);
                    }else{
                        System.out.println(tmp);
                    }
                }
            }
            for(int i = 0; i < 3; i++){
                if(!receive_index.isEmpty()){
                    Schooler tmp = receive_index.poll();
                    if(tmp.f3 == 1){
                        receive_high_school_documents.add(tmp);
                    }else{
                        System.out.println(tmp);
                    }
                }
            }
            if(!receive_high_school_documents.isEmpty()){
                Schooler tmp = receive_high_school_documents.poll();
                System.out.println(tmp);
            }
        }
    }
}
