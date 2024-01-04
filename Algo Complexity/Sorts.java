import java.util.Random;

/**
 * Contains examples of different sorting algorithms for sorting
 * arrays. These are static methods that any client can use.
 * 
 * @author S. Anderson
 * @author Henry Wandover
 */

public class Sorts {
	private static Random rand = new Random();
	public static long counterBubble;
	public static long counterInsertion;

	/**
	 * sort the elements of an array with bubble sort. On each pass
	 * through the array, the largest element is moved to the end of
	 * the array.
	 */
	public static void bubbleSort(int b[]) {
		int last = b.length - 1;
		boolean swapped = false;

		// Pass over the array b.length-1 times.
		for (int pos = 0; pos < b.length - 1; pos++) {
			// push larger elements downward
			for (int i = 0; i < last; i++) {

				counterBubble++;
				if (b[i] > b[i + 1]) {
					swap(b, i, i + 1);
					swapped = true;
				}
			}
			// INVARIANT: largest element from b[0..last] is in b[last]
			// exit if no items swapped
			if (swapped)
				swapped = false;
			else
				break;
			last--;
		}
	}

	/** swap two elements of an array */
	public static void swap(int c[], int first, int second) {
		int hold = c[first]; // temporary holding area for swap
		c[first] = c[second];
		c[second] = hold;
	}

	/**
	 * Simple insertion sort.
	 * 
	 * @param a an array of integers.
	 */
	public static void insertionSort(int a[]) {
		// Iterates over length inserting values and sliding down the
		// values that are less than
		for (int i = 0; i < a.length; i++) {
			int curr = a[i];
			int j = i - 1;

			// ASSERT: The previous value can only go back as far as the first
			// index, and it must be greater than the current value
			while (j >= 0 && a[j] > curr) {
				counterInsertion++;
				a[j + 1] = a[j];
				j--;
			}
			counterInsertion++;
			// Insert
			a[j + 1] = curr;
		}
	}

	/**
	 * Fills array with random numbers from 1 to maxnum.
	 * PRE: a.length > 0
	 */

	public static void randomArray(int a[], int maxnum) {
		for (int i = 0; i < a.length; i++) {
			a[i] = 1 + (int) (Math.random() * maxnum);
		}

	}

	/*
	 * Test that all elements of b are found in a.
	 * Test whether a, a sorted array, contains all elements of b.
	 * Also ensures a is sorted in increasing order.
	 */
	private static boolean testArray(int[] a, int[] b) {
		if (a.length != b.length)
			return false;
		java.util.Arrays.sort(b); // assume this sort is correct

		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i])
				return false;
		}
		return true;
	}

	/**
	 * Test the various sort algorithms for correctness.
	 */
	public static void main(String[] args) {
		int N = Integer.parseInt(args[0]);

		String[] methods = { "bubble", "insert" };
		int nums[], numscpy[];
		// test sorts for N arrays of size N.
		for (String method : methods) {
			for (int i = 1; i < N; i++) {
				// create arrays
				nums = new int[i];
				Sorts.randomArray(nums, nums.length);
				numscpy = nums.clone();
				// Use one of the sorting methods
				if (method.equals("bubble"))
					Sorts.insertionSort(nums);
				else if (method.equals("insert"))
					Sorts.insertionSort(nums);
				// Test the sort used for correctness.
				if (!Sorts.testArray(nums, numscpy)) {
					System.out.println("Failed sort test " + i);
					System.exit(-1);
				}
			}
		}

		// test binary search for N arrays.
		for (int i = N - 1; i < N; i++) {
			// create arrays
			nums = new int[i];
			Sorts.randomArray(nums, nums.length);
			numscpy = nums.clone();
			Sorts.insertionSort(nums);
			// Check for all items via binarySearch
			for (int x : numscpy) {
				if (!Searches.binarySearch(x, nums)) {
					System.out.println("Failed binary search test");
					System.exit(-1);

				}
			}
		}
	}

} // end of Sorts
