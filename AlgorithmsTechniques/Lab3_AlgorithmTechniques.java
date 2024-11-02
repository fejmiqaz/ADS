package Labs.AlgorithmsTechniques;

import java.util.Scanner;

/* We are given N digits. Write an algorithm that composes the largest possible number from those digits.
 * Input: The first number in the input is the number of digits N, then in the next line are the given digits.
 * Output: The largest possible number containing those digits.
 * 5
 * 1 2 3 4 5
 * Output:
 * 54321
 *
 * 7
 * 9 7 3 7 9 3 1
 * Output:
 * 9977331 */

public class Lab3_AlgorithmTechniques {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n - 1 - i; j++){
                if(arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
        }
    }
}
