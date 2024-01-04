/*
  A couple of basic searching algorithms.
*/

public class Searches {
	public static long counterSearch;
	public static long counterBinary;

	/**
      @returns true iff x is found in a
      
      Uses simple sequential search.
    */
    public  static boolean search(int x, int a[]) {
	for (int i = 0; i < a.length; i++) {
		counterSearch++;
	    if (x == a[i]) {
		return true;
	    }
	}
	return false;
    }

	/**
	 * @returns true iff x is found in a
	 * @param x   the integer to find
	 * @param a[] the array to search
	 * 
	 *            Uses iterative binary search.
	 */
	public static boolean binarySearch(int x, int a[]) {

		if (a == null)
			return false;
		int first = 0;
		int last = a.length - 1;
		int mid;

		while (first < last) {
			counterBinary++;
			mid = (first + last) / 2;
			counterBinary++;
			if (a[mid] < x) {
				first = mid + 1;
			} else
				last = mid;
		}
		counterBinary++;

		counterBinary++;
		if (a[first] == x)
			return true;
		// not found and array exhausted
		return false;
	}

}
