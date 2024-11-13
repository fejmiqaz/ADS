package Labs.AlgorithmsTechniques;

import java.util.Scanner;

/* Basic fibonacci sequence solved. */

public class Lab4_DP_1 {

    public static int fibonacci(int n) {
        if(n==0){
            return 0;
        }else if(n==1){
            return 1;
        }
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

//        System.out.println(fibonacci(n));

        if(n == 1) {System.out.println(1);}
        if(n==0) {System.out.println(0);}

        int [] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1;
        for(int i = 2; i <= n; i++){
             dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);
    }
}
