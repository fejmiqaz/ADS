package SLL;

import java.util.Scanner;

public class Lab1<E> {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		int n = input.nextInt();
		
		SLL<Integer> list = new SLL<>();
		
		for(int i = 0; i < n; i++) {
			int number = input.nextInt();
			
			if(number >= 10) {
				list.inserFirst(number);
			}
		}
		
		for(int i = 0; i < n; i++) {
			list.sort(list);
		}
		
		System.out.print(list);
		
	}
	
}
