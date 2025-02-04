package Hashing;

import java.util.Scanner;
import java.util.*;


class Person {
    public String name;
    public String surname;
    public int budget;
    public String ipAddress;
    public String time;
    public String city;
    public int price;

    public Person(String name, String surname, int budget, String ipAddress, String time, String city, int price) {
        this.name = name;
        this.surname = surname;
        this.budget = budget;
        this.ipAddress = ipAddress;
        this.time = time;
        this.city = city;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getBudget() {
        return budget;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getTime() {
        return time;
    }

    public String getCity() {
        return city;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return budget == person.budget && price == person.price && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(ipAddress, person.ipAddress) && Objects.equals(time, person.time) && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, budget, ipAddress, time, city, price);
    }

    @Override
    public String toString() {
        return name + " " + surname + " " + budget +
                " " + ipAddress +
                " " + time +
                " " + city +
                " " + price;
    }
}

public class Hash_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        CBHT<String, Integer> m1 = new CBHT<>(n);
        CBHT<String, Person> m2 = new CBHT<>(n);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            String name = sc.next();
            String surname = sc.next();
            int budget = sc.nextInt();
            String ipAddress = sc.next();
            String time = sc.next();
            String city = sc.next();
            int price = sc.nextInt();
            Person person = new Person(name, surname, budget, ipAddress, time, city, price);
            String [] parts = ipAddress.split("\\.");
            String networkPart = parts[0] + "." + parts[1] + "." + parts[2];
            SLLNode<MapEntry<String,Integer>> ipAddressNode = m1.search(networkPart);
            SLLNode<MapEntry<String, Person>> personNode = m2.search(networkPart);
            if(ipAddressNode == null){
                if(budget >= price){
                    m1.insert(networkPart, 1);
                }
            }else{
                if(budget >= price){
                    int val = ipAddressNode.element.value;
                    m1.insert(networkPart, val + 1);
                }
            }

            if(personNode == null){
                if(budget >= price){
                    m2.insert(networkPart, person);
                }
            }else{
                if(budget >= price){
                    int most = personNode.element.value.budget;
                    if(most < budget){
                        m2.insert(networkPart, person);
                    }
                }
            }
        }
        sc.nextLine();
        int k = sc.nextInt();
        for(int i = 0; i < k; i++){
            String name =sc.next();
            String surname=sc.next();
            int budget=sc.nextInt();
            String ip=sc.next();
            String time=sc.next();
            String city=sc.next();
            int price=sc.nextInt();
            String [] parts = ip.split("\\.");
            String networkPart = parts[0] + "." + parts[1] + "." + parts[2];
            SLLNode<MapEntry<String,Integer>> ipAddressNode = m1.search(networkPart);
            System.out.println("IP network: " + networkPart + " has the following number of users:");
            System.out.println(ipAddressNode.element.value);
            SLLNode<MapEntry<String,Person>> personNode = m2.search(networkPart);
            System.out.println("The user who spent the most from that network is:");
            System.out.println(personNode.element.value.name + " " + personNode.element.value.surname + " with salary " + personNode.element.value.budget + " from address " + personNode.element.value.ipAddress + " who spent " + personNode.element.value.price);
            System.out.println();
        }
    }
}
