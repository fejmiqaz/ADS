package Labs.AlgorithmsTechniques;

import java.util.Scanner;

/* There were N adults and M children that wanted to travel from the bus station in FinTown to the neighbouring city MinTown.
The price of one ticket is 100 den. If an adult wants to travel with K children, he would need to pay one ticket for him
 and K-1 tickets for the children (the ticket for one of the children is free). The adults can also travel by themselves,
 in which case they only pay one ticket. Additionally, we know that the children can't travel without being accompanied by an adult.
In the first row the number N is given, and then in the second row the number M. You need to calculate the minimum and the
 maximum value in den. that the passengers can pay for their tickets, and print them in two separate lines.
 There will be at least one adult in the bus.
For example:
Input Result
4
10
Output:
1000
1300
Input:
3
2
Output:
300
400
*/

public class Lab3_AlgorithmsTechniques_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int adults = sc.nextInt();
        int kids = sc.nextInt();
        int price = 100;
        int min, max;

        if (adults < kids) {
            int temp = kids - adults;
            min = (adults + temp) * price;
            max = (adults + kids - 1) * price;
        }else{
            min = adults * price;
            max = (adults * price) + (kids*price) - price;
        }

        System.out.println("Min: " + min);
        System.out.println("Max: " + max);
    }
}
