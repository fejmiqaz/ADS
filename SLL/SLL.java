package SLL;

public class SLL<E> {
	private SLLNode<E> first;
	public SLL() {
		this.first = null;
	}
	
	
	public SLLNode<E> getFirst() {
		return first;
	}
	
	public void setFirst(SLLNode<E> e) {
		this.first = e;
	}
	
	public void inserFirst(E o) {
		SLLNode<E> ins = new SLLNode<E> (o, first);
		first = ins;
	}
	
	public void insertAfter(E o, SLLNode<E> node) {
		if(node != null) {
			SLLNode<E> ins = new SLLNode<E> (o, node.succ);
			node.succ = ins; 
		}
	}
	
	public E deleteFirst() {
		if(first != null) {
			SLLNode<E> tmp = first;
			first = first.getSucc();
			return tmp.element;
		}
		return null;
	}
	
	public E delete(SLLNode<E> node) {
		if(first != null) {
			SLLNode<E> tmp = first;
			while(tmp.succ != node && tmp.succ.succ != null) {
				tmp = tmp.succ;
				if(tmp.succ == node) {
					tmp.succ = tmp.succ.succ;
					return node.element;
				}
			}
		}
		return null;
	}
	
	public int length() {
		int ret;
		if(first != null) {
			SLLNode<E> tmp = first;
			ret = 1;
			while(tmp.succ != null) {
				tmp = tmp.succ;
				ret++;
			}
			return ret;
		}else {
			return 0;
		}
	}
	
	public E reverse() {
		if(first != null) {
			SLLNode<E> tmp = first;
			SLLNode<E> newsucc = null;
			SLLNode<E> next;
			while(tmp != null) {
				next = tmp.succ;
				tmp.succ = newsucc;
				newsucc = tmp;
				tmp = next;
			}
			first = newsucc;
		}
		return null;
	}
	
	public void removeDuplicates(SLL<E> list) {
		SLLNode<E> current = list.getFirst();
		SLL<E> list2 = new SLL<E>();
		
		while(current != null && current.getSucc() != null) {
			if(current.element.equals(current.getSucc().element)) {
				current.succ = current.getSucc().getSucc();
			}else {
				current = current.getSucc();
			}
		}
	}
	
	public SLL<E> sort(SLL<E> list){
		
		if(list == null) {
			return null;
		}
		
		
		SLLNode<E> current = list.getFirst();
		SLL<E> newList = new SLL<>();
		
		int cnt = 1;
		
		while(list != null) {
			
			while(current != null) {
				current = current.getSucc();
				cnt++;
			}
			
			if(cnt > 10) {
				current = list.getFirst();
				
				while(current != null) {
					E firstElement = current.element;
					current = current.getSucc();
					
					if(current != null) {
						E secondElement = current.element;
						E mergedElement = (E) (Integer.valueOf((Integer) firstElement + (Integer) secondElement));
						newList.inserFirst(mergedElement);
						current = current.getSucc();
					}else {
						newList.inserFirst(firstElement);
					}
				}
			}else {
				return list;
			}
			
			
		}
		
		return newList;
	}
	
}
