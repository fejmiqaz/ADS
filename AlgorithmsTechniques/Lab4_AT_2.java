package Labs.AlgorithmsTechniques;
import java.util.Scanner;
import java.util.Arrays;

/* You are given an array of integers arr of length n and an integer target.
Your goal is to find the smallest number in the array that is strictly greater than target.
If no such number exists, print "Not Found".
5
1 3 5 7 9
4
Output: 5
4
2 4 6 8
8
Output: No
 */
public class Lab4_AT_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int m = sc.nextInt();
        int l = 0;
        int r = n;
        int smallest = Integer.MAX_VALUE;
        while(l < r){
            int mid = (l+r)/2;
            if(arr[mid]>m){
                if(arr[mid]<smallest){
                    smallest = arr[mid];
                }
                r = mid;
            }else {
                l = mid + 1;
            }
        }
        if(smallest == Integer.MAX_VALUE){
            System.out.println("No");
        }else{
            System.out.println(smallest);
        }
    }
}
