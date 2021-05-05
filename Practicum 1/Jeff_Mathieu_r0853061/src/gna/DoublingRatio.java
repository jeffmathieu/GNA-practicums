package gna;

public class DoublingRatio {
	

	public static void doublingTest() {
		
		
		
		
		InsertionSort insertionSort = new InsertionSort();
		System.out.println("Insertion Sort");
		
		for (int i = 50; i < 51201; i *= 2) {
			
			Comparable[] array = Main.newArray(i);
			insertionSort.totalComparisons = 0;
			insertionSort.totalSwaps = 0;
			long startTime = System.nanoTime();
			
			insertionSort.InsertionSort(array);
			
			long endTime = System.nanoTime();

			long duration = (endTime - startTime) / 1000000;  //divide by 1000000 to get milliseconds.
			
			System.out.print(i + ", totalCompares = " + insertionSort.totalComparisons + ", totalSwaps = " + insertionSort.totalSwaps + ", time: " + duration + " ms");
			System.out.println();
		}
		
		
		
		QuickSort quickSort = new QuickSort();
		System.out.println("Quick Sort");
		
		for (int i = 50; i < 51201; i *= 2) {
			
			Comparable[] array = Main.newArray(i);
			quickSort.totalComparisons = 0;
			quickSort.totalSwaps = 0;
			long startTime = System.nanoTime();
			int n = array.length - 1;
			
			quickSort.QuickSort(array, 0, n);
			
			long endTime = System.nanoTime();

			long duration = (endTime - startTime) / 1000000;  //divide by 1000000 to get milliseconds.
			
			System.out.print(i + ", totalCompares = " + quickSort.totalComparisons + ", totalSwaps = " + quickSort.totalSwaps + ", time: " + duration + " ms");
			System.out.println();
		}

		
		System.out.println();
		
		
		
	}
}
