import java.util.Scanner;
import java.util.Arrays;

/* We are given a street with N possible positions on which we can put a light. A single light will illuminate its own position
* and 2 more positions to the left and 2 more to the right of it. Our task is to illuminate the street with the minimum possible lights.
* Not all possible positions must contain light.
* Input: The first number in the input is the number of possible positions to put a light bulb N and the length of the street M,
* then in the next line are the possible positions on which we can put a light.
* Output: The minimum lights we need to illuminate the street
* Example:
* 5 5
* 1 2 3 4 5
* Output: 1
* 3 10
* 3 8 9
* Output : 2
* 3 15
* 3 8 13
* Output: 3
* 8 15
* 3 8 13 10 1 3 5 9
* Output: 3
*/

public class Lab3_AlgorithmsTechniques_3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

//   ********** APPROACH 1 *********** -> Me & Faik

        Arrays.sort(arr);
        int count = 0;
        int covered = 0;
        int i = 0;
        if(arr[0] > 2){
            covered++;
        }

        while(covered < m){
            int lastCovered = -1;
            while (i<n && arr[i] <= covered + 3) {
                lastCovered = arr[i]+2;
                i++;
            }
            if (lastCovered == -1){
                System.out.println(-1);
                return;
            }
            covered = lastCovered;
            count++;
        }
        System.out.println(count);

//   *********** APPROACH 2 ************* -> shout out Fisnik

//        int covered = 1;
//        int i = 0;
//        int cnt = 0;
//
//        while(covered < m-1){
//            if(arr[i] == covered){
//                if(covered - 2 > 0 && covered + 2 <= m){
//                    cnt++;
//                }
//                i++;
//            }
//            covered++;
//        }
//        System.out.println(cnt);

    }
}
