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

    public static void quickSortDescending(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);
            quickSortDescending(arr, low, pivot-1);
            quickSortDescending(arr, pivot+1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] > pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        /* QUICK SORT */
        quickSortDescending(arr, 0, n-1);
        long largestNumber = 0;
        for (int i = 0; i < n; i++) {
            largestNumber = largestNumber * 10 + arr[i];
        }

        System.out.print(largestNumber);

        /* BUBBLE SORT */
        /*for(int i = 0; i < n; i++){
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
        }*/
    }
}
