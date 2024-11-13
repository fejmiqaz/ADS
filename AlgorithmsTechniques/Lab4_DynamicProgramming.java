package Labs.AlgorithmsTechniques;

import java.util.Scanner;

/* What is the minimum number we need to subtract the square of an integer for a number x to become 0?
* Input: Integer X from 1 to 10^5
* Output: The result
* Examples:
* Input
* 13
* 21
* 25
* 32
* Output
* 2
* 3
* 1
* 16
*
*  */

public class Lab4_DP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int res = 100000000;
        double sqrt = Math.sqrt(x);
        int[] dp = new int[x+1];
        dp[0] = 0;

        for (int i = 1; i <= x; i++) {
            dp[i] = 100000000;
        }
        for (int i = 1; i <= sqrt; i++){
            dp[i*i] = 1;
        }
        for(int i = 1; i <=x; i++){
            for(int j = 1; j < i; i++){
                dp[i] = Math.min(dp[i], dp[j] + dp[i-j]);
            }
        }
        System.out.println(dp[x]);
    }
}
