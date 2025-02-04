package Hashing;

import java.util.Objects;
import java.util.Scanner;

class PPerson {
    String name;
    String surname;
    int budget;
    String network;
    String time;
    String city;
    int price;

    public PPerson(String name, String surname, int budget, String network, String time, String city, int price) {
        this.name = name;
        this.surname = surname;
        this.budget = budget;
        this.network = network;
        this.time = time;
        this.city = city;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PPerson pPerson = (PPerson) o;
        return budget == pPerson.budget && price == pPerson.price && Objects.equals(name, pPerson.name) && Objects.equals(surname, pPerson.surname) && Objects.equals(network, pPerson.network) && Objects.equals(time, pPerson.time) && Objects.equals(city, pPerson.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, budget, network, time, city, price);
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + budget + " " + network + " " + time + " " + city + " " + price;
    }
}

public class Hash_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        CBHT<String, Integer> m1 = new CBHT<>(n);
        CBHT<String, PPerson> m2 = new CBHT<>(n);
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String surname = sc.next();
            int budget = sc.nextInt();
            String ip = sc.next();
            String time = sc.next();
            String city = sc.next();
            int price = sc.nextInt();
            PPerson p = new PPerson(name, surname, budget, ip, time, city, price);
            String [] parts = ip.split("\\.");
            String network = parts[0] + "." + parts[1] + "." + parts[2];
            SLLNode<MapEntry<String,Integer>> m1Node = m1.search(network);
            if(m1Node == null) {
                String [] parts2 = time.split(":");
                int h = Integer.parseInt(parts2[0]);
                int m = Integer.parseInt(parts2[1]);
                if(h>11){
                    m1.insert(network, 1);
                }
            }else{
                String [] parts2 = time.split(":");
                int h = Integer.parseInt(parts2[0]);
                int m = Integer.parseInt(parts2[1]);
                int val = m1Node.element.value;
                if(h>11){
                    m1.insert(network, val + 1);
                }
            }
            SLLNode<MapEntry<String, PPerson>> m2Node = m2.search(network);
            if(m2Node == null) {
                String [] parts2 = time.split(":");
                int h = Integer.parseInt(parts2[0]);
                if(h>11){
                    m2.insert(network,p);
                }
            }else{
                String [] parts2 = time.split(":");
                int h = Integer.parseInt(parts2[0]);
                int m = Integer.parseInt(parts2[1]);
                if(h>11){
                    String val = m2Node.element.value.time;
                    String [] parts3 = val.split(":");
                    int h1 = Integer.parseInt(parts3[0]);
                    int m3 = Integer.parseInt(parts3[1]);
                    if(h1>h){
                        m2.insert(network,p);
                    }else if (h1==h&&m3>m){
                        m2.insert(network,p);
                    }
                }
            }
        }
        sc.nextLine();
        int k = sc.nextInt();
        for(int i = 0; i < k; i++){
            String name = sc.next();
            String surname = sc.next();
            int budget = sc.nextInt();
            String ip = sc.next();
            String time = sc.next();
            String city = sc.next();
            int price = sc.nextInt();
            PPerson p = new PPerson(name, surname, budget, ip, time, city, price);
            String [] parts = ip.split("\\.");
            String network = parts[0] + "." + parts[1] + "." + parts[2];
            SLLNode<MapEntry<String,Integer>> m1Node = m1.search(network);
            if(m1Node != null) {
                System.out.println("IP network: " + network + " has the following number of users:");
                System.out.println(m1Node.element.value);
            }
            SLLNode<MapEntry<String, PPerson>> m2Node = m2.search(network);
            if(m2Node != null) {
                System.out.println("The user who logged on earliest after noon from that network is:");
                System.out.println(m2Node.element.value.name + " " + m2Node.element.value.surname + " with salary "+ m2Node.element.value.budget + " from address " + m2Node.element.value.network + " who logged in at " + m2Node.element.value.time);
                System.out.println();
            }
        }
    }
}
