package gna;

/**
 * Performs sort by using the Selection Sort algorithm.
 * 
 */
public class SelectionSort extends SortingAlgorithm{
	
	int totalComparisons;
	int totalSwaps;
	
	/**
	 * Sorts the given array using selection sort.
	 * 
	 * @see super
	 */
	public long sort(Comparable[] array) throws IllegalArgumentException {
		if (array == null) {
			throw new IllegalArgumentException("argument 'array' must not be null.");
		}

		totalComparisons = 0;
		totalSwaps = 0;

		SelectionSort(array);
		System.out.println(totalSwaps);
		return totalComparisons;
	}

	/**
	 * Constructor.
	 */
	public void SelectionSort(Comparable[] a) {
		 int n = a.length;
		 for (int i = 0; i < n; i++) {
			 int min = i;
			 for (int j = i + 1; j < n; j++) {
				 totalComparisons++;
				 if (Template.less(a[j], a[min])) 
					 min = j;
				
			 }
			 if (i != min) {
				 Template.exchange(a, i, min);
				 totalSwaps++;
			 }
		 }
	}
}

