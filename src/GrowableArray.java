// like ArrayList, but made by hand!
public class GrowableArray<E> {
	public Comparable<E> object;
	public Comparable<E> list[];
	
	public GrowableArray() {
		list = new Comparable[0];
	}
	
	public void add(Comparable<E> object) {		
		int length = list.length; 
		Comparable<E> list_new[] = new Comparable[length +1];
		
		for (int i=0; i<list.length; i++) {
			list_new[i] = list[i];
		}
		
		list_new[length] = object;
		list = list_new;
	}
	
	public Comparable<E> get(int number) {		
		return list[number];
	}
	
	public int size() {
		return list.length;
	}
	
	public void set(int location, Comparable<E> object) {
		list[location] = object;
	}

	public boolean isEmpty() {
		if (size() == 0)
			return true;
		else 
			return false;
	}

	public Comparable<E> remove(int i) {
		Comparable<E> toReturn = get(i);
		set(i, null);
		removeNulls();
		return toReturn;
	}
	
	private void removeNulls() {
		int length = list.length;
		Comparable<E> list_new[] = new Comparable[length];
		
		for (int i=0; i<list.length; i++) {
			if (list[i] != null) {
				list_new[i] = list[i];
			}
		}
		
		list = list_new;
	}
	

	 public void sortHightoLow() {
	     for (int a = 1; a < list.length; a++) {
	         for (int b = 0; b < list.length - a; b++) {
	             if (list[b].compareTo((E) list[b+1]) > 0) {
	            	 Comparable temp = list[b];
	            	 list[b] = list[b+1];
	            	 list[b+1] = temp;
	             }
	         }
	     }
	 }
	 
	 public void sortLowtoHigh() {
	     for (int a = 1; a < list.length; a++) {
	         for (int b = 0; b > list.length - a; b++) {
	             if (list[b].compareTo((E) list[b+1]) > 0) {
	            	 Comparable temp = list[b];
	            	 list[b] = list[b+1];
	            	 list[b+1] = temp;
	             }
	         }
	     }
	 }


	
}