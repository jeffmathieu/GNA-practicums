package gna;

import java.util.Random;

import org.junit.Test;

/**
 * Tests that test whether the implementations of the sorting algorithms do sort.
 */
public class SortingAlgorithmsTest {

	@Test
	public void my_first_test() {

		// Insertion Test
		InsertionSort insertionSort = new InsertionSort();
		
		Comparable[] insertionArray = newArray(100);
		
		insertionSort.sort(insertionArray);
		assert checkIfCorrect(insertionArray) == true;
		
		// Insertion Test 2 (short array)
		InsertionSort insertionSort1 = new InsertionSort();
		
		Comparable[] insertionArray1 = newArray(10000);
		
		insertionSort1.sort(insertionArray1);
		assert checkIfCorrect(insertionArray1) == true;
		
		
		
		
		// Selection Test
		SelectionSort selectionSort = new SelectionSort();
		
		selectionSort.totalComparisons = 0;
		
		Comparable[] selectionArray = newArray(100);
		selectionSort.SelectionSort(selectionArray);
		assert checkIfCorrect(selectionArray) == true;
		
		
		// Selection Test 2 (short array)
		SelectionSort selectionSort1 = new SelectionSort();
		
		Comparable[] selectionArray1 = {5, 6, 4, 8, 9, 1, 2, 3, 7};
		selectionSort1.SelectionSort(selectionArray1);
		assert checkIfCorrect(selectionArray1) == true;
		
		
		
		
		// gna.QuickSort Test
		QuickSort quickSort = new QuickSort();
		
		quickSort.totalComparisons = 0;
		
		Comparable[] quickArray = newArray(10000);
		
		
		quickSort.sort(quickArray);
		assert checkIfCorrect(quickArray) == true;
		
		// gna.QuickSort Test 2 (short array)

		QuickSort quickSort1 = new QuickSort();
		
		quickSort1.totalComparisons = 0;
		
		Comparable[] quickArray1 = newArray(10);
		
		
		quickSort1.sort(quickArray1);
		assert checkIfCorrect(quickArray1) == true;	

	}
	
	private static Comparable[] newArray(int i) {
		Random rd = new Random();
		Comparable[] array = new Comparable[i];
		for (int j = 0; j < array.length; j++) {
			array[j] = rd.nextInt() / 10000000;
		}
		return array;
	}
	
	private static boolean checkIfCorrect(Comparable[] a) {
		for (int i = 0; i < a.length - 1; i++) {
			if (Template.less(a[i + 1], a[i]))
				return false;
		}
		return true;
	}
	
	public static void printArray(Comparable[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			
		}
		System.out.println();
	}

}
