package Labs.AlgorithmsTechniques;

import java.util.Scanner;

/* You are climbing a staircase n. Each time, you can either climb 1 step or 2 steps. Calculate the distinct number of ways to reach the top.
* Example
* Input: n = 4
* Output: 5 (1+1+1+1), (1+1+2), (1+2+1), (2+1+1), (2+2)
*  */

public class Lab4_DP_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[n]);
    }
}
