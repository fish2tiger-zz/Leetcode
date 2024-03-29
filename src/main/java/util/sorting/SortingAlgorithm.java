package util.sorting;

/**
 * SortingAlgorithm the entry class for all types of sort algorithms.
 * @author epttwxz
 *
 */
public class SortingAlgorithm {

	public static <T> void selectSort(Comparable<T>[] input) {
		new SelectionSort().sort(input);
	}

	public static void bubblesort(int[] input) {
		new BubbleSort().sort(input);
	}

	public static void insertSort(int[] input) {
		InsertionSort.InsertionSortinstance.sort2(input);
	}

	public static void quicksort(int[] input) {
		QuickSortImpl.instance.sort(input, 0, input.length - 1);
	}
	
	public static void mergesort(int[]input){
		MergeSort.instance.sortX_entry(input);
	}
	
	

}
