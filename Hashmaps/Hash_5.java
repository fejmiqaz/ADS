package Hashing;

import java.util.Scanner;

class BloodGroup {
    public String name;
    public String group;

    public BloodGroup(String name, String group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return group;
    }
}

public class Hash_5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        OBHT<String, Integer> obht = new OBHT<String, Integer>(N);
        for(int i = 1; i <= N; i++){
            String name = sc.next();
            String group = sc.next().replaceAll("[1-2]", "");
            int bucket = obht.search(group);
            if(bucket == -1){
                obht.insert(group, 1);
            }else{
                obht.insert(group, obht.getBucket(bucket).value + 1);
            }
        }
        System.out.println(obht.toString());
    }
}
