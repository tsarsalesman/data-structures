import java.util.Arrays;

/**
 * This class is used to test the running time of
 * algorithms by counting comparisons.
 * 
 * @author Henry Wandover
 */

public class TestRuntime {

	public static void main(String[] args) {

		// check the command line to get arraysize
		if (args.length != 1) {
			System.err.println("USAGE: java TestRuntime arraysize");
			System.exit(-1);
		}

		// Create an array to use
		int arraysize = Integer.parseInt(args[0]);
		int nums[] = new int[arraysize];
		int numscpy[];
		long counterBubble[] = new long[10];
		long counterInsertion[] = new long[10];
		long counterSearch[] = new long[10];
		long counterBinary[] = new long[10];

		for (int j = 0; j < 10; j++) {

			// fill array with random integers in range [1,length]
			// System.out.print("Creating the random array...");
			Sorts.randomArray(nums, nums.length);
			numscpy = nums.clone(); // make copy of nums
			// print(nums);
			// System.out.println("done.");

			Sorts.counterBubble = 0;
			// System.out.print("Sorting via bubble sort...");
			Sorts.bubbleSort(nums);
			// print(nums);
			//System.out.println(Sorts.counterBubble);
			counterBubble[j] = Sorts.counterBubble;

			Sorts.counterInsertion = 0;
			nums = numscpy; // revert to unsorted array
			// System.out.print("Sorting via insertion sort...");
			Sorts.insertionSort(nums);
			// System.out.println(Sorts.counterInsertion);
			counterInsertion[j] = Sorts.counterInsertion;

			Searches.counterSearch = 0;
			// System.out.print("Sequential search...");
			for (int i = 0; i < nums.length; i++) {
				Searches.search(i, nums);
			}
			// System.out.println(Searches.counterSearch);
			counterSearch[j] = Searches.counterSearch;

			Searches.counterBinary = 0;
			// System.out.print("Binary search...");
			for (int i = 0; i < nums.length; i++) {
				Searches.binarySearch(i, nums);
			}
			// System.out.println(Searches.counterBinary);
			counterBinary[j] = Searches.counterBinary;
		}
		for (long i : counterBubble) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();

		for (long i : counterInsertion) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();

		for (long i : counterSearch) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();

		for (long i : counterBinary) {
			System.out.print(i);
			System.out.print(" ");
		}
		System.out.println();
	}

	/**
	 * Print the array.
	 */
	public static void print(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}

}
