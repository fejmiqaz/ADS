package SLL;

public class SLLCycleDetector<E> {
	public boolean hasCycle(SLL<E> list) {
		SLLNode<E> slow = list.getFirst();
		SLLNode<E> fast = list.getFirst();
		
		if(list.getFirst() != null) {
			while(fast != null && fast.getSucc() != null) {
				slow = slow.getSucc();
				fast = fast.getSucc().getSucc();
				
				if(fast.equals(slow)) {
					return true;
				}
			}
		}
		return false;
	}
}
