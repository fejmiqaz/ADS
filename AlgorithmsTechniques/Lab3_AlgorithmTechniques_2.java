/* We are given N tasks with estimated completion time and the amount we can earn from that task. Write an algorithm that
* finds the maximum earnings we can have for 40 hours. Note that we can have a partial earning from a partially completed task.
* Input: The first number in the input is the number of tasks N, then in the next N lines are  the time needed for the task (in hours)
* and the amount of money we can earn from it.
* Output: The maximum amount we can earn in 40 hours.
* Example:
* 3
* 10 60
* 20 100
* 30 120
* Output:
* 200
* Example 2:
* 1
* 10 60
* Output:
* 60 */

import java.util.Scanner;
public class Lab3_AlgorithmTechniques_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int overallHours = 40;
        double overallAmount = 0;
        while(n>0){
            int hours = sc.nextInt();
            int amount = sc.nextInt();
            if(hours <= overallHours){
                overallAmount += amount;
                overallHours -= hours;
            }else{
                overallAmount += amount * ((double) overallHours / hours);
                overallHours = 0;
            }
            n--;
        }
        System.out.println((int)overallAmount);

    }
}
