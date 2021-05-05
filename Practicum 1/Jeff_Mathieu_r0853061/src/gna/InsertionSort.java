package gna;

/**
 * Performs sort by using the Insertion Sort algorithm.
 * 
 */
public class InsertionSort extends SortingAlgorithm{
	
	int totalComparisons;
	int totalSwaps;
	
	
	/**
	 * Sorts the given array using insertion sort.
	 * 
	 * @see super
	 */
	public long sort(Comparable[] array) throws IllegalArgumentException {
		if (array == null) {
			throw new IllegalArgumentException("argument 'array' must not be null.");
		}

		totalComparisons = 0;
		totalSwaps = 0;

		InsertionSort(array);
		
		return totalComparisons;
	}


	

	
	/**
	 * Constructor.
	 */
	public void InsertionSort(Comparable[] a) {
		int n = a.length;
		for (int i = 1; i < n; i++) {
			for (int j = i; j > 0; j--) {
				if (Template.less(a[j], a[j - 1])) {
					Template.exchange(a, j, j-1);
					totalSwaps++;
					totalComparisons++;
				}
				else if (Template.less(a[j - 1], a[j])) {
					totalComparisons++;
					break;
				}
				
				
				
				
			}
		}
	}
	
	
}
