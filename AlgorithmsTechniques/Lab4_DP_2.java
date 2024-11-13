package Labs.AlgorithmsTechniques;

import java.util.Scanner;

/* Given a number n, find the minimum number of steps to reduce it to 1.
* Input:
* 10
* Output: 3, sequence is 10->9->3->1 */

public class Lab4_DP_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int [] dp = new int[n+1];
        for(int i = 1; i <= n; i++){
            dp[i] = dp[i-1] + 1;
            if(i % 2 == 0){
                dp[i] = Math.min(dp[i], dp[i/2] + 1);
            }
            if(i % 3 == 0){
                dp[i] = Math.min(dp[i], dp[i/3] + 1);
            }
        }
        System.out.println(dp[n]);
    }
}
