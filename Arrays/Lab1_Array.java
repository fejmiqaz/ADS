package Labs;

import java.util.Scanner;

public class Lab1_Array {

    public static void deleteSmallerDigits(Integer n, Integer[] arr) {
        Integer sum = 0;
        for(int i = 0; i < n; i++){
            sum += arr[i];
        }
        float average = (float)sum / n;

        Integer cnt = 0;

        for(int i = 0; i < n; i++){
            if(arr[i] >= average){
                cnt++;
            }
        }

        for(int i = 0; i < n; i++){
            if(arr[i] >= average){
                System.out.print(arr[i]);
                cnt--;
                if(cnt > 0){
                    System.out.print(",");
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

        System.out.print("{");
        for(Integer i = 0; i < n; i++){
            System.out.print(arr[i]);
            if(i == n-1){ break; }
            System.out.print(",");
        }
        System.out.print("}");

        System.out.println();

        System.out.print("{");
        deleteSmallerDigits(n, arr);
        System.out.print("}");
    }
}
