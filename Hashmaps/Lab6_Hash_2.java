package Labs.Hashmaps;

import java.util.Scanner;


public class Lab6_Hash_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CBHT<String, String> table = new CBHT<String, String>(n);
        sc.nextLine();
        for (int i = 0; i < n; i++) {
            String username = sc.next();
            String password = sc.next();
            table.insert(username, password);
        }
        CBHT<String, String> table2 = new CBHT<String, String>(n);
        while (true) {
            String line = sc.next();
            if(line.equals("KRAJ")){
                break;
            }
            String username = line;
            String password = sc.next();

            SLLNode<MapEntry<String, String>> exits = table.search(password);
            if(exits != null) {
                table2.insert(username, password);
                if(table2.equals(table.search(password))) {
                    System.out.println("Najaven");
                }else{
                    System.out.println("Nenajaven");
                }
            }else{
                if(table2.equals(table.search(password))){
                    System.out.println("Najaven");
                }else{
                    System.out.println("Nenajaven");
                }
            }
        }
    }
}
