package SLL;

public class SLLMiddleElement<E> {
	
	public SLLNode<E> findMiddle(SLL<E> list){
		SLLNode<E> slow = list.getFirst();
		SLLNode<E> fast = list.getFirst();
		
		if(list.getFirst() != null) {
			while(fast != null && fast.getSucc() != null) {
				slow = slow.getSucc();
				fast = fast.getSucc().getSucc();
			}
			
			return slow;
		}else {
			return null;
		}	
	}
}
