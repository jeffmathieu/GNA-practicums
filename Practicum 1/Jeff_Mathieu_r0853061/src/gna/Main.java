package gna;

import java.util.Random;


public class Main {

	
	public static void main(String[] args) {

		InsertionSort insertionSort = new InsertionSort();
		long[] resultsInsertionComparisons = new long[100];
		long[] resultsInsertionSwaps = new long[100];
		for (int i = 1; i <= resultsInsertionComparisons.length; i++) {
			insertionSort.totalSwaps = 0;
			insertionSort.totalComparisons = 0;
			Comparable[] arr = newArray(i);
			insertionSort.sort(arr);
			resultsInsertionSwaps[i - 1] = insertionSort.totalSwaps;
			resultsInsertionComparisons[i - 1] = insertionSort.totalComparisons;
			
		}
		
		printArray(resultsInsertionSwaps, "gna.InsertionSort Swaps");
		System.out.println();
		printArray(resultsInsertionComparisons, "gna.InsertionSort Comparisons");
		System.out.println();

		QuickSort quickSort = new QuickSort();
		long[] resultsQuickSwaps = new long[100];
		long[] resultsQuickComparisons = new long[100];
		for (int i = 1; i <= resultsQuickSwaps.length; i++) {
			quickSort.totalSwaps = 0;
			quickSort.totalComparisons = 0;
			Comparable[] arr = newArray(i);
			quickSort.sort(arr);
			resultsQuickSwaps[i - 1] = quickSort.totalSwaps;
			resultsQuickComparisons[i - 1] = quickSort.totalComparisons;
			
		}
		
		printArray(resultsQuickSwaps, "gna.QuickSort Swaps:");
		System.out.println();
		printArray(resultsQuickComparisons, "gna.QuickSort Comparisons");
		System.out.println();

		SelectionSort selectionSort = new SelectionSort();
		long[] resultsSelectionSwaps = new long[100];
		long[] resultsSelectionComparisons = new long[100];
		for (int i = 1; i <= resultsSelectionSwaps.length; i++) {
			selectionSort.totalSwaps = 0;
			selectionSort.totalComparisons = 0;
			Comparable[] arr = newArray(i);
			selectionSort.SelectionSort(arr);
			resultsSelectionSwaps[i - 1] = selectionSort.totalSwaps;
			resultsSelectionComparisons[i - 1] = selectionSort.totalComparisons;
		
		}
		
		printArray(resultsSelectionSwaps, "gna.SelectionSort Swaps:");
		System.out.println();
		printArray(resultsSelectionComparisons, "gna.SelectionSort Comparisons:");
		System.out.println();
		
		
		// Doubling experiment gna.InsertionSort
		
		DoublingRatio.doublingTest();

		// Meest gunstige rij test (1000 elementen)
		
		Comparable[] gunstig = newGunstigeArray(1000);
		
		// gna.InsertionSort
		
		//gna.InsertionSort insertionSort = new gna.InsertionSort(); //remove "//" if tested separately
		insertionSort.totalComparisons = 0;
		insertionSort.InsertionSort(gunstig);
		System.out.println("gna.InsertionSort (gunstige rij) vergelijkingen = " + insertionSort.totalComparisons);
		System.out.println();

		// SelecionSort
		
		//gna.SelectionSort selectionSort = new gna.SelectionSort(); //remove "//" if tested separately
		selectionSort.totalComparisons = 0;
		selectionSort.SelectionSort(gunstig);
		System.out.println("gna.SelectionSort (gunstige rij) vergelijkingen = " + selectionSort.totalComparisons);
		System.out.println();
		
		// gna.QuickSort
		
		//gna.QuickSort quickSort = new gna.QuickSort(); //remove "//" if tested separately
		quickSort.totalComparisons = 0;
		int n = gunstig.length - 1;
		quickSort.QuickSort(gunstig, 0, n);
		System.out.println("gna.QuickSort (gunstige rij) vergelijkingen = " + quickSort.totalComparisons);
		System.out.println();

	}

	
	public static Comparable[] newArray(int i) {
		Random rd = new Random();
		Comparable[] array = new Comparable[i];
		for (int j = 0; j < array.length; j++) {
			array[j] = rd.nextInt();
		}
		return array;
	}
	
	public static void printArray(long[] results, String x) {
		System.out.println(x + " ");
		for(int i = 0; i < results.length; i++) {
			System.out.print(results[i] + " ");
		}
		System.out.println();
	}

	public static void printArray(Comparable[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] +  " ");
			
		}
		System.out.println();
	}
	
	public static Comparable[] newGunstigeArray(int x) {
		Comparable[] array = new Comparable[x];
		for (int i = 1; i <= array.length; i++) {
			array[i - 1] = i;
		}
		return array;
	}
	
}
