package Hashing;

import java.util.Objects;
import java.util.Scanner;

class HumanBeing {
    String name;
    String surname;
    int budget;
    String ip;
    String time;
    String city;
    int price;

    public HumanBeing(String name, String surname, int budget, String ip, String time, String city, int price) {
        this.name = name;
        this.surname = surname;
        this.budget = budget;
        this.ip = ip;
        this.time = time;
        this.city = city;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        HumanBeing that = (HumanBeing) o;
        return budget == that.budget && price == that.price && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(ip, that.ip) && Objects.equals(time, that.time) && Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, budget, ip, time, city, price);
    }

    @Override
    public String toString() {
        return name +
                " " + surname+
                " " + budget +
                " " + ip +
                " " + time +
                " " + city +
                " " + price;
    }
}

public class Hash_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        CBHT<String, HumanBeing> cbht1 = new CBHT<String,HumanBeing>(n);
        CBHT<String, Integer> cbht2 = new CBHT<String, Integer>(n);
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String surname = sc.next();
            int budget = sc.nextInt();
            String ip = sc.next();
            String time = sc.next();
            String city = sc.next();
            int price = sc.nextInt();
            HumanBeing p = new HumanBeing(name, surname, budget, ip, time, city, price);
            SLLNode<MapEntry<String,Integer>> first = cbht2.search(city);
            if(first == null){
                String [] pts = time.split(":");
                int h = Integer.parseInt(pts[0]);
                if(h>11){
                    cbht2.insert(city, 1);
                }
            }else{
                String [] pts = time.split(":");
                int h = Integer.parseInt(pts[0]);
                int m = Integer.parseInt(pts[1]);
                int val = cbht2.search(city).element.value;
                if(h>11){
                    cbht2.insert(city, val + 1);
                }
            }
            SLLNode<MapEntry<String, HumanBeing>> second = cbht1.search(city);
            if(second == null){
                String [] pts = time.split(":");
                int h = Integer.parseInt(pts[0]);
                if(h>11){
                    cbht1.insert(city, p);
                }
            }else{
                String [] pts = time.split(":");
                int h = Integer.parseInt(pts[0]);
                int m = Integer.parseInt(pts[1]);
                if(h>11){
                    String [] pts2 = second.element.value.toString().split(":");
                    int h1 = Integer.parseInt(pts2[0]);
                    int m1 = Integer.parseInt(pts2[1]);
                    if(h1<h){
                        cbht1.insert(city, p);
                    }else if(h1==h && m1<m){
                        cbht1.insert(city, p);
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
            SLLNode<MapEntry<String, Integer>> m =  cbht2.search(city);
            if(m != null){
                System.out.println("City: " + city + " has the following number of customers:");
                System.out.println(m.element.value);
            }
            SLLNode<MapEntry<String, HumanBeing>> f =  cbht1.search(city);
            if(f != null){
                System.out.println("The user who logged on earliest after noon from that city is:");
                System.out.println(f.element.value.name + " " + f.element.value.surname + " with salary " + f.element.value.budget + " from address" + f.element.value.ip + " who logged in at " + f.element.value.time);
            }
        }
    }
}
