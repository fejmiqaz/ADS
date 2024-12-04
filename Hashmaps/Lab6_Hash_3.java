package Labs.Hashmaps;

import java.util.HashMap;
import java.util.*;
import java.util.Scanner;


public class Lab6_Hash_3 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        HashMap<String, Set<String>> routerRoutes = new HashMap<String, Set<String>>();
        for(int i = 0; i < n; i++){
            String interfaceIP = sc.nextLine();
            Set<String> networks = new HashSet<>();

            String network;
            while(!(network = sc.nextLine()).isEmpty()){
                networks.add(network);
            }
            routerRoutes.put(interfaceIP, networks);
        }
        int attempts = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < attempts; i++){
            String interfaceIP = sc.nextLine();
            String destinationIP = sc.nextLine();
            if(routerRoutes.containsKey(interfaceIP) && routerRoutes.get(interfaceIP).contains(destinationIP)){
                System.out.println("postoi");
            }else{
                System.out.println("ne postoi");
            }
        }
        System.out.println(routerRoutes);
    }
}