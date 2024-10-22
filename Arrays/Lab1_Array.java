/* For a given array with N integers, all the elements that are lower than the average of the whole array
need to be deleted. For example for the array 1, 2, 3, 4, 5 the average is (1 + 2 + 3 + 4 + 5) / 5 = 15 / 5 = 3 
which means that the elements 1 and 2 should be deleted, so the array after the transformation will be 3, 4, 5. */

import java.util.Scanner;

public class Lab1_Array {

    public static void deleteSmallerDigits(Integer n, Integer[] arr) {
        Integer sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i]; // sum all the elements in the array
        }
        float average = (float)sum / n; // get the average by casting one of the dividing numbers into float

        Integer cnt = 0; // set a counter to count the elements that are bigger than the average

        for(int i = 0; i < n; i++){
            if(arr[i] >= average){
                cnt++; // count those elements
            }
        }
        // print those elements with a comma until it reaches the end of the array, which indicates that the counter = 0 (last element)
        for(int i = 0; i < n; i++){
            if(arr[i] >= average){
                System.out.print(arr[i]);
                cnt--;
                if(cnt > 0){
                    System.out.print(","); // so this means as long as counter isn't 0 (last element), print a comma after each element
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Integer n = input.nextInt();

        Integer[] arr = new Integer[n];

        for(int i = 0; i < n; i++){
            arr[i] = input.nextInt();
        }
        // ^^ input of the array
        System.out.print("{");
        for(Integer i = 0; i < n; i++){
            System.out.print(arr[i]);
            if(i == n-1){ break; } // we can use this logic since we know where the last element is in the original array, but not on the modified one, it can be at index n-2, n-5...
            System.out.print(",");
        }
        System.out.print("}");

        System.out.println();

        System.out.print("{");
        deleteSmallerDigits(n, arr); // ^^ above
        System.out.print("}");
    }
}
