package SLL;

public class SLLSubsectionReverser<E> {
	
	
	public void reverseSubsection(SLL<E> list, int start, int end) {
		
		if(list == null || start < 0 || end < start) {
			return;
		}
		
		SLLNode<E> current = list.getFirst();
		SLLNode<E> prev = null;
		
		for(int i = 0; current != null && i < start; i++) {
			prev = current;
			current = current.getSucc();
		}
		
		SLLNode<E> startNode = current;
		SLLNode<E> next = null;
		
		for(int i = 0; current != null && i <= end - start; i++) {
			next = current.getSucc();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		
		if(startNode != null) {
			startNode.setNext(current);
		}
		
		if(prev!= null) {
			if(start == 0) {
				list.setFirst(prev);
			}else {
				SLLNode<E> temp = list.getFirst();
				for(int i = 0; i < start - 1; i++) {
					temp = temp.getSucc();
				}
				
				temp.setNext(prev);
			}
		}
		
	}
	
}
