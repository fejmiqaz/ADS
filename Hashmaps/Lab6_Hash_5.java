package Labs.Hashmaps;

import java.util.HashMap;
import java.util.Scanner;

class Healer {
    public String name;
    public int amount;
    public int price;

    Healer() {}
    Healer(String name, int price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
    }
    @Override
    public String toString() {
        return name + " " + amount + " " + price ;
    }
}

public class Lab6_Hash_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        Healer healer = new Healer();
        CBHT<Healer, Integer> table = new CBHT<Healer, Integer>(n);
        for(int i = 0; i < n; i++) {
            String [] parts = sc.nextLine().split(" ");
            String name = parts[0];
            int status = Integer.parseInt(parts[1]);
            int price = Integer.parseInt(parts[2]);
            int amount = Integer.parseInt(parts[3]);
            healer = new Healer(name, price, amount);
            table.insert(healer,status);
        }
        while(true){
            String [] parts = sc.nextLine().split(" ");
            String name = parts[0];
            if(name.equals("KRAJ")){
                break;
            }
            int amount = Integer.parseInt(parts[1]);

            SLLNode<MapEntry<Healer,Integer>> exists = table.search(healer);
            if(exists != null){
                if((!name.equals(exists.element.key.name)) && (amount > exists.element.key.amount)){
                    System.out.println("The product doesn't exist or has not enough amount of it!");
                }else{
                    System.out.println("Napravena naracka");
                }
            }else {
                System.out.println("Nema takov lek!");
            }
        }

    }
}
