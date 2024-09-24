package SLL;

import java.util.Scanner;

public class SLLDuplicateRemover {

	
	public static void main(String[] args) {
		SLL<Integer> list = new SLL<>();
		
		list.inserFirst(1);
		list.inserFirst(1);
		list.inserFirst(3);
		list.inserFirst(3);
		list.inserFirst(4);
		
        System.out.print("Before removing duplicates: \n");
        printList(list);
        list.removeDuplicates(list);
        System.out.print("After removing duplicates: \n");
        printList(list);
		
	}
	
	public static void printList(SLL<Integer> list) {
		SLLNode<Integer> current = list.getFirst();
		while(current != null) {
			System.out.print(current.element + " -> ");
			current = current.getSucc();
		}
		System.out.println("null");
	}

	
	
}
