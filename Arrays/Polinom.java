package Array;

public class Polinom {
	Array<Integer> coefficient;
	public Polinom(Array<Integer> coefficient) {
		this.coefficient = coefficient;
	}
	
	public Array<Integer> getCoefficient(){
		return coefficient;
	}
	
	public void setCoefficient(Array<Integer> coefficient) {
		this.coefficient = coefficient;
	}
	
	public Polinom addPolinoms(Polinom o) {
		Polinom result;
		Array<Integer> coefficient2 = o.getCoefficient();
		
		int n = coefficient.get(0);
		int m = coefficient2.get(0);
		
		Array<Integer> results = new Array<Integer> (n * 2 + m * 2 + 1);
		
		int i = 1, j = 1, k = 1;
		while(i <= 2 * n && j <= 2 * m) {
			if(coefficient.get(i) == coefficient2.get(j)) {
				result.setCoefficient(k+1, coefficient.get(i+1) + coefficient2.get(j+1));
				if(result.get(k+1) != null) {
					result.setCoefficient(k, coefficient.get(i));
					k+=2;
				}
				i+=2; j+=2;
			}
		}
	}
	
	@Override
	public String toString() {
		String set = new String();
		for(int i = 1; i <= coefficient.get(0) * 2; i += 2) {
			set += coefficient.get(i+1) + "* x^" + coefficient.get(i) +" ";
		}
		return set;
	}
}
