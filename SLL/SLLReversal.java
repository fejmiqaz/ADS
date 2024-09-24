package SLL;

public class SLLReversal {
	
	private SLL list;
	
	public SLLReversal(SLL list) {
		this.list = list;
	}
	
	public void reverse(SLL list) {
		
		SLLNode prev = null;
		SLLNode current = list.getFirst();
		SLLNode next = null;
		
		while(current != null) {
			next = current.getSucc();
			current.setNext(prev);
			prev = current;
			current = next;
		}
		
		list.setFirst(prev);
		
	}
}
