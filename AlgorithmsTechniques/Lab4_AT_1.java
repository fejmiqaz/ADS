package Labs.AlgorithmsTechniques;
import java.util.Scanner;

/* We are given an array of N numbers. Using the method "divide and conquer" write a binary search algorithm that searches for a given number M. If the number is found, print the position of the number in the array. If the number is not in the array, print "Ne postoi".

Input: The first number in the input is the size of the array N, and the number we are searching M. Then in the next line are the array elements.

Output: The position of the number we are searching, or "Ne postoi" if no such number exists in the array.
 5 3
1 2 3 4 5
Output: 2
7 7
1 2 3 4 5 6 7
Output: 6

10 0
10 20 30 40 50 60 70 80 90 100
Output: Doesn't exist

 */

public class Lab4_AT_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int [] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        int l = 0;
        int r = n;
        while(l < r){
            int mid = (l+r)/2;
            if(arr[mid]>=m){
                r = mid;
            }else if(arr[mid] < m){
                l = mid + 1;
            }
        }
        if(l == n || arr[l] != m){
            System.out.print("Ne postoi");
        }else{
            System.out.print(l);
        }

    }
}
