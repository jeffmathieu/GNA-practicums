package gna;

public class Template {
	
	
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	
	public static void exchange(Comparable[] a, int i, int j) {
		Comparable t = a[i]; 
		a[i] = a[j];
		a[j] = t;
	}
	
	
}
