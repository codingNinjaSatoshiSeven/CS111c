
import java.util.Arrays;


public class FastSorts {
	public static final int MIN_SIZE = 5; // for quick sort

	public static <T extends Comparable<? super T>> void selectionSort(T[] a,
			int n) {
		selectionSort(a, 0, n - 1); // invoke recursive method
	} // end selectionSort


	public static <T extends Comparable<? super T>> void selectionSort(T[] a,
			int first, int last) {
		if (first < last) { // place the smallest value at beginning of array:
			int indexOfNextSmallest = getIndexOfSmallest(a, first, last);
			swap(a, first, indexOfNextSmallest);
			selectionSort(a, first + 1, last);
		} // end if
	} // end selectionSort

	
	private static <T extends Comparable<? super T>> int getIndexOfSmallest(
			T[] a, int first, int last) {
		T min = a[first];
		int indexOfMin = first;
		for (int index = first + 1; index <= last; index++) {
			if (a[index].compareTo(min) < 0) {
				min = a[index];
				indexOfMin = index;
				// Assertion: min is the smallest of a[first] through a[index].
			} // end if
		} // end for
		return indexOfMin;
	} // end getIndexOfSmallest

	
	public static <T extends Comparable<? super T>> void selectionSort2(T[] a,
			int n) {
		selectionSort2(a, 0, n - 1);
	} // end selectionSort2

	public static <T extends Comparable<? super T>> void selectionSort2(T[] a,
			int first, int last) {
		if (first < last) { // place the largest value at end of array:
			swap(a, getIndexOfLargest(a, first, last), last);
			selectionSort2(a, first, last - 1);
		} // end if
	} // end selectionSort2

	
	private static <T extends Comparable<? super T>> int getIndexOfLargest(
			T[] a, int first, int last) {
		T max = a[first];
		int indexOfMax = first;
		for (int index = first + 1; index <= last; index++) {
			if (a[index].compareTo(max) > 0) {
				max = a[index];
				indexOfMax = index;
				// Assertion: max is the largest of a[first] through a[index].
			} // end if
		} // end for

		return indexOfMax;
	} // end getIndexOfLargest
	// -------------------------------------------------------------------------------

	// INSERTION SORT
	public static <T extends Comparable<? super T>> void insertionSort(T[] a,
			int n) {
		insertionSort(a, 0, n - 1);
	} // end insertionSort

	// 11.12
	public static <T extends Comparable<? super T>> void insertionSort(T[] a,
			int first, int last) {
		if (first < last) {
			// sort all but the last element
			insertionSort(a, first, last - 1);

			// insert the last element in sorted order
			insertInOrder(a[last], a, first, last - 1);
		} // end if
	} // end insertionSort

	// ALTERNATE VERSIONS
	public static <T extends Comparable<? super T>> void insertionSort2(T[] a,
			int n) {
		insertionSort2(a, 0, n - 1);
	} // end insertionSort2

	public static <T extends Comparable<? super T>> void insertionSort2(T[] a,
			int first, int last) {
		if (first < last) {
			insertionSort2(a, first, last - 1); // sort all but last item
			insertInOrder(a[last], a, first, last - 1); // insert last item in
														// sorted order
		} // end if
	} // end insertionSort2

	/**
	 * Task: Inserts element into the sorted array elements a[begin] through
	 * a[end]. Based on pseudocode in 11.13.
	 */
	private static <T extends Comparable<? super T>> void insertInOrder(
			T element, T[] a, int begin, int end) {
		if (element.compareTo(a[end]) >= 0)
			a[end + 1] = element;
		else if (begin < end) {
			a[end + 1] = a[end];
			insertInOrder(element, a, begin, end - 1);
		} else {
			a[end + 1] = a[end];
			a[end] = element;
		} // end if
	} // end insertInOrder

	// -------------------------------------------------------------------------------

	// BUBBLE SORT
	public static <T extends Comparable<? super T>> void recursiveBubbleSort(
			T[] a, int n) {
		if (n > 1) {
			for (int index = 0; index < n - 1; index++)
				order(a, index, index + 1);

			recursiveBubbleSort(a, n - 1);
		} // end if
	} // end recursiveBubbleSort
	// -------------------------------------------------------------------------------

	// MERGE SORT
	public static <T extends Comparable<? super T>> void mergeSort(T[] a, int n) {
		mergeSort(a, 0, n - 1);
	} // end mergeSort

	public static <T extends Comparable<? super T>> void mergeSort(T[] a,
			int first, int last) {
		T[] tempArray = (T[]) new Comparable<?>[a.length];
		mergeSort(a, tempArray, first, last);
	} // end mergeSort

	private static <T extends Comparable<? super T>> void arrayPrinter(T[] a, int first, int last) {
		System.out.print("[");
		for(int i=first; i<last; i++) {
			System.out.print(a[i]+", ");
		}
		System.out.println(a[last]+"]");
	}
	
	private static <T extends Comparable<? super T>> void mergeSort(T[] a,
			T[] tempArray, int first, int last) {
		
		arrayPrinter(a, first, last);
		
		if (first < last) { // sort each half
			int mid = (first + last) / 2;// index of midpoint
			mergeSort(a, first, mid); // sort left half array[first..mid]
			mergeSort(a, mid + 1, last); // sort right half array[mid+1..last]

			if (a[mid].compareTo(a[mid + 1]) > 0) // Question 2, Chapter 12
				merge(a, tempArray, first, mid, last); // merge the two halves
			// else skip merge step
		} // end if
	} // end mergeSort

	private static <T extends Comparable<? super T>> void merge(T[] a,
			T[] tempArray, int first, int mid, int last) {
		// Two adjacent subarrays are a[beginHalf1..endHalf1] and
		// a[beginHalf2..endHalf2].
		int beginHalf1 = first;
		int endHalf1 = mid;
		int beginHalf2 = mid + 1;
		int endHalf2 = last;

		// while both subarrays are not empty, copy the
		// smaller item into the temporary array
		int index = beginHalf1; // next available location in
								// tempArray
		for (; (beginHalf1 <= endHalf1) && (beginHalf2 <= endHalf2); index++) { 
			if (a[beginHalf1].compareTo(a[beginHalf2]) < 0) {
				tempArray[index] = a[beginHalf1];
				beginHalf1++;
			} else {
				tempArray[index] = a[beginHalf2];
				beginHalf2++;
			} // end if
		} // end for

		// finish off the nonempty subarray

		// finish off the first subarray, if necessary
		for (; beginHalf1 <= endHalf1; beginHalf1++, index++)
			// Invariant: tempArray[beginHalf1..index-1] is in order
			tempArray[index] = a[beginHalf1];

		// finish off the second subarray, if necessary
		for (; beginHalf2 <= endHalf2; beginHalf2++, index++)
			// Invariant: tempa[beginHalf1..index-1] is in order
			tempArray[index] = a[beginHalf2];

		// copy the result back into the original array
		for (index = first; index <= last; index++)
			a[index] = tempArray[index];
		
		arrayPrinter(a, first, last);
	} // end merge
	// -------------------------------------------------------------------------------

	// QUICK SORT
	public static void quickSort(Comparable[] array, int n) {
		quickSort(array, 0, n - 1);
	} // end quickSort

	// 12.18
	/**
	 * Task: Sorts an array into ascending order. Uses quick sort with
	 * median-of-three pivot selection for arrays of at least MIN_SIZE elements,
	 * and uses insertion sort for other arrays.
	 */
	public static <T extends Comparable<? super T>> void quickSort(T[] a,
			int first, int last) {
		if (last - first + 1 < MIN_SIZE) {
			insertionSort(a, first, last);
		} else {
			// create the partition: Smaller | Pivot | Larger
			int pivotIndex = partition(a, first, last);
			arrayPrinter(a, first, last);
			// sort subarrays Smaller and Larger
			quickSort(a, first, pivotIndex - 1);
			quickSort(a, pivotIndex + 1, last);
		} // end if
	} // end quickSort

	// 12.17
	/**
	 * Task: Partitions an array as part of quick sort into two subarrays called
	 * Smaller and Larger that are separated by a single element called the
	 * pivot. Elements in Smaller are <= pivot and appear before the pivot in
	 * the array. Elements in Larger are >= pivot and appear after the pivot in
	 * the array.
	 * 
	 * @param a
	 *            an array of Comparable objects
	 * @param first
	 *            the integer index of the first array element; first >= 0 and <
	 *            a.length
	 * @param last
	 *            the integer index of the last array element; last - first >=
	 *            3; last < a.length
	 * @return the index of the pivot
	 */
	private static <T extends Comparable<? super T>> int partition(T[] a,
			int first, int last) {
		int mid = (first + last) / 2;
		sortFirstMiddleLast(a, first, mid, last);
		System.out.println("after sort first mid last");
		arrayPrinter(a, first, last);
		
		// Assertion: The pivot is a[mid]; a[first] <= pivot and
		// a[last] >= pivot, so do not compare these two array elements
		// with pivot.

		// move pivot to next-to-last position in array
		swap(a, mid, last - 1);
		int pivotIndex = last - 1;
		System.out.println("after swapping mid and last-1");
		arrayPrinter(a, first, last);
		T pivot = a[pivotIndex];

		// determine subarrays Smaller = a[first..endSmaller]
		// and Larger = a[endSmaller+1..last-1]
		// such that elements in Smaller are <= pivot and
		// elements in Larger are >= pivot; initially, these subarrays are empty

		int indexFromLeft = first + 1;
		int indexFromRight = last - 2;
		boolean done = false;
		while (!done) {
			// starting at beginning of array, leave elements that are < pivot;
			// locate first element that is >= pivot; you will find one,
			// since last element is >= pivot
			while (a[indexFromLeft].compareTo(pivot) < 0)
				indexFromLeft++;

			// starting at end of array, leave elements that are > pivot;
			// locate first element that is <= pivot; you will find one,
			// since first element is <= pivot
			while (a[indexFromRight].compareTo(pivot) > 0)
				indexFromRight--;

			assert a[indexFromLeft].compareTo(pivot) >= 0
					&& a[indexFromRight].compareTo(pivot) <= 0;

			if (indexFromLeft < indexFromRight) {
				swap(a, indexFromLeft, indexFromRight);
				System.out.println("after swapping the indices");
				arrayPrinter(a, first, last);
				indexFromLeft++;
				indexFromRight--;
			} else
				done = true;
		} // end while

		// place pivot between Smaller and Larger subarrays
		swap(a, pivotIndex, indexFromLeft);
		pivotIndex = indexFromLeft;

		// Assertion:
		// Smaller = a[first..pivotIndex-1]
		// Pivot = a[pivotIndex]
		// Larger = a[pivotIndex+1..last]

		return pivotIndex;
	} // end partition

	// 12.16
	/**
	 * Task: Sorts the first, middle, and last elements of an array into
	 * ascending order.
	 * 
	 * @param a
	 *            an array of Comparable objects
	 * @param first
	 *            the integer index of the first array element; first >= 0 and <
	 *            a.length
	 * @param mid
	 *            the integer index of the middle array element
	 * @param last
	 *            the integer index of the last array element; last - first >=
	 *            2, last < a.length
	 */
	private static <T extends Comparable<? super T>> void sortFirstMiddleLast(
			T[] a, int first, int mid, int last) {
		order(a, first, mid); // make a[first] <= a[mid]
		order(a, mid, last); // make a[mid] <= a[last]
		order(a, first, mid); // make a[first] <= a[mid]
	} // end sortFirstMiddleLast

	/**
	 * Task: Orders two given array elements into ascending order so that a[i]
	 * <= a[j].
	 * 
	 * @param a
	 *            an array of Comparable objects
	 * @param i
	 *            an integer >= 0 and < array.length
	 * @param j
	 *            an integer >= 0 and < array.length
	 */
	private static <T extends Comparable<? super T>> void order(T[] a, int i,
			int j) {
		if (a[i].compareTo(a[j]) > 0)
			swap(a, i, j);
	} // end order

	/**
	 * Task: Swaps the array elements a[i] and a[j].
	 * 
	 * @param a
	 *            an array of objects
	 * @param i
	 *            an integer >= 0 and < a.length
	 * @param j
	 *            an integer >= 0 and < a.length
	 */
	private static void swap(Object[] a, int i, int j) {
		Object temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	} // end swap
} // end SortArrayRecursive