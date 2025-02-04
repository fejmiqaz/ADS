package Hashing;

import java.util.Scanner;

class Birthday {
    public String day;
    public String month;
    public String year;

    public Birthday(String day, String month, String year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    @Override
    public String toString() {
        return day + " " + month + " " + year;
    }
}

public class Hash_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        CBHT<String,Integer> cbht = new CBHT<String,Integer>(n);
        for (int i = 0; i < n; i++) {
            String [] parts = sc.nextLine().split("\\.");
            SLLNode<MapEntry<String,Integer>> node = cbht.search(parts[1]);
            if(node == null) {
                cbht.insert(parts[1], 1);
            }else{
                SLLNode<MapEntry<String,Integer>> bday = cbht.search(parts[1]);
                cbht.insert(parts[1], bday.element.value + 1);
            }
        }
        String month = sc.nextLine();
        SLLNode<MapEntry<String,Integer>> res = cbht.search(month);
        if(res == null) {
            System.out.println("NO");
        }else{
            System.out.println(res.element.value);
        }
    }
}
