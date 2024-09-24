package Array;

public class Array<E> {
	
	private E data[];
	private int size;
	public Array(int size) {
		data = (E[])new Object[size];
		this.size = size;
	}
	
	public void set(int position, E o) {
		if(position >= 0 && position < size) {
			data[position] = o;
		}
	}
	
	public E get (int position) {
		if(position >= 0 && position < size) {
			return data[position];
		}
		return null;
	}
	
	public int find(E o) {
		for(int i = 0; i < size; i++) {
			if(o.equals(data[i])) {
				return i;
			}
			return -1;
		}
		return size;
	}
	
	public int getLength() {
		return size;
		
	}
	
	public void insert(int position, E o) {
		if(position >= 0 && position < size) {
			E[] newData = (E[]) new Object[size + 1];
			
			for(int i = 0; i < position; i++) {
				newData[i] = data[i];
			}
			for(int i = position; i < size; i++) {
				newData[i+1] = data[i];
			}
			
			data = newData;
			size = size + 1;
		}
	}
	
	public void delete(int position) {
		if(position >= 0 && position < size) {
			E[] newData = (E[]) new Object[size - 1];
			for(int i = 0; i < position; i++) {
				newData[i - 1] = data[i];
			}
		
			data = newData;
			size = size - 1;
		}
	}
	
	public void resize(int newSize) {
		
	}

}
