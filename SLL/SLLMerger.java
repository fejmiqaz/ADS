package SLL;

public class SLLMerger<E extends Comparable<E>> {
	
	public SLL<E> mergeSorted(SLL<E> list1, SLL<E> list2) {
		
		SLLNode<E> current1 = list1.getFirst();
		SLLNode<E> current2 = list2.getFirst();
		SLL<E> list3 = new SLL<E>();
		
		
		while(current1 != null && current2 != null) {
			if(current1.element.compareTo(current2.element) <= 0) {
				list3.inserFirst(current1.element);
				current1 = current1.getSucc();
			}else {
				list3.inserFirst(current2.element);
				current2 = current2.getSucc();
			}
		}
		
		while(current1 != null) {
			list3.inserFirst(current1.element);
			current1 = current1.getSucc();
		}
		
		while(current2 != null) {
			list3.inserFirst(current2.element);
			current2 = current2.getSucc();
		}
		
		return list3;
	}
}
