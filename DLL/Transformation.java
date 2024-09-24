package DLL;

import java.util.Scanner;

public class Transformation {
	private static DLLNode<Element> cumulativeSum(DLL<Element> list, int value){
		DLLNode<Element> tmp = list.getFirst();
		int sum = 0;
		while( tmp != list.getLast()) {
			sum += tmp.element.getId();
			if(sum > value) {
				break;
			}
			tmp = tmp.succ;
		}
		return tmp;
	}
	
	private static void listTransform(DLL<Element> original, int n) {
		DLLNode<Element> last;
		while(n!=0) {
			last = original.getLast();
			original.insertBefore(last.element, cumulativeSum(original, last.element.getId()));
			n--;
			original.deleteLast();
		}
		System.out.println(original.toString());
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = Integer.parseInt(scanner.nextLine());
		int N = Integer.parseInt(scanner.nextLine());
		
		DLL<Element> list = new DLL<Element>();
		
		for(int i = 0; i < num; i++) {
			int n = scanner.nextInt();
			list.insertLast(new Element(n));
		}
		
		listTransform(list, N);
	
	}

}
