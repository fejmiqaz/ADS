package Labs.Hashmaps;

import java.util.Scanner;

public class Lab6_Hash_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CBHT<String, String> table = new CBHT<String, String>(n);
        sc.nextLine();
        for(int i = 0; i < n; i++){
            String mk = sc.next();
            String eng = sc.next();
            table.insert(mk, eng);
        }
        while(true){
            String eng = sc.next();
            if(eng.equals("KRAJ")){
                break;
            }
            SLLNode<MapEntry<String,String>> exists = table.search(eng);
            if(exists != null && exists.element.value.equals(eng)){
                System.out.println(exists.element.key);
            }else{
                System.out.println("Doesnt exist");
            }
        }
    }
}
