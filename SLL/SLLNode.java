package SLL;

public class SLLNode<E> {
	protected E element;
	protected SLLNode<E> succ;
	public SLLNode(E elem, SLLNode<E> succ) {
		this.element = elem;
		this.succ = succ;
	}
	
	public void setNext(SLLNode<E> e) {
		this.succ = e;
	}
	
	public SLLNode<E> getSucc(){
		return succ;
	}
}
