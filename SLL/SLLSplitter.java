package SLL;

public class SLLSplitter<E> {
	
	public SLL<SLL<E>> splitList(SLL<E> list){
		
		if(list.getFirst() == null) {
			return (SLL<SLL<E>>) new SLL<E>();
		}
		
		SLLNode<E> slow = list.getFirst();
		SLLNode<E> fast = list.getFirst();
		SLL<E> firstHalf = new SLL<E>();
		SLL<E> secondHalf = new SLL<E>();
		
		while(fast != null && fast.getSucc() != null) {
			fast = fast.getSucc().getSucc();
			if(fast != null) {
				firstHalf.inserFirst(slow.element);
				slow = slow.getSucc();
			}
		}
		
		while(slow != null) {
			secondHalf.inserFirst(slow.element);
			slow = slow.getSucc();
		}
		
		SLL<SLL<E>> result = new SLL<>();
		
		result.inserFirst(firstHalf);
		result.inserFirst(secondHalf);
		
		return result;
		
	}
}
