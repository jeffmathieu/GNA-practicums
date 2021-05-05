package gna;

/**
 * Performs sort by using the Quick Sort algorithm.
 *
 */
public class QuickSort extends SortingAlgorithm{
	
	int totalComparisons;
	int totalSwaps;
	
	/**
	 * Sorts the given array using quick sort.
	 * 
	 * @see super
	 */
	public long sort(Comparable[] array) throws IllegalArgumentException {
		if (array == null) {
			throw new IllegalArgumentException("argument 'array' must not be null.");
		}

		totalComparisons = 0;
		totalSwaps = 0;

		int n = array.length - 1;
		
		QuickSort(array, 0, n);
		
		//System.out.println(totalComparisons);
		return totalComparisons;
		
	}

	
	public int partition(Comparable[] a, int start, int end) {
		int i = start;
		int j = end + 1;
		Comparable v = a[start];
		while(true) {
			while (Template.less(a[++i], v)) {
				totalComparisons++; 
				if (i == end) {
					break;
				}
			}
			
			while (Template.less(v, a[--j])) {
				totalComparisons++; 
				if (j == start) {
					break;
				}
			}
			
			if (i >= j) {
				break;
			}
			Template.exchange(a, i, j);
			totalSwaps++;
		}
		Template.exchange(a, start, j);
		totalSwaps++;
		return j;
	}
	
	/**
	 * Constructor.
	 */
	public void QuickSort(Comparable[] a, int start, int end) {
		if(end <= start) {
			return;
		}
		int j = partition(a, start, end);
		QuickSort(a, start, j - 1);
		QuickSort(a, j + 1, end);
	}
}
