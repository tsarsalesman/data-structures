/**
   Create words to solve a jumble problem of one sequence
   of characters.
   @author HENRY WANDOVER
 */

import java.io.*;   // for IO
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class SpellCheck {
    public static final int NOT_FOUND = -1;
    // default values for dictionary and document
    private static final String dictFilename = "./";
    private static final String docFilename = "dictionary.txt";
    private String [] dictionary; // Array of words in dictionary.

	private static long CompCount;

    /**
      Load dictionary used for spell checking
      File must contain one word per line.
    */
    public SpellCheck(String filename) {
		ArrayList<String> words = new ArrayList<String>();
		FileReader filereader = null;

		try {
			filereader = new FileReader(filename);
		} catch (FileNotFoundException ex) {
			System.err.println(ex);
			return;
		}
		BufferedReader reader = new BufferedReader(filereader);
		String s;
		try {
			while ( (s = reader.readLine()) != null ) {
			words.add( s );
			}
			// convert arraylist to an array
			this.dictionary = words.toArray(new String [1]);
		} catch (IOException ex) {
			System.err.println("Error reading " + filename);
		}
    }

    /**
	 * Return ith element from dictionary.
	 * @param i Index of word in dictionary.
    */
    public String get(int i) { return dictionary[i]; }

    /**
	 * Wrapper method, if given a true boolean then it will run indexOf with a sorted key and dictionary
	 * @param key the target word that is serched for
	 * @param _sorted Informs the method if it should sort words and dict or not.
	 * @return index in list of words of spell checker.
    */
    public int indexOf(String key, boolean _sorted) {
        if (key == null)
	    	throw new IllegalArgumentException("argument to indexOf() is null");
		CompCount++;
		if (_sorted == true) {
			key = sortLetters(key);
			for (int i = 0; i < dictionary.length; i++) { dictionary[i] = sortLetters(dictionary[i]); }
			QuickSort.quickSort(dictionary);
			return indexOf(dictionary, key, 0,dictionary.length-1);
		}
		CompCount++;

		return indexOf(dictionary, key, 0,dictionary.length-1);
    }

    /**
	 * @param arr The array that is being searched through
	 * @param target the word that is being searched for
	 * @param lo responsible for sweeping the left side
	 * @param hi does the right side
       @return index in array of key or NOT_FOUND if not found
       Uses String compareTo method. A recursive BinarySearch implementation.
    */
    private static int indexOf(String[] arr, String target, int lo, int hi) {
		if (lo > hi) return NOT_FOUND;
		CompCount++;

		int mid = (lo + hi) / 2;

		CompCount++;
		if (arr[mid].compareTo(target) < 0) {
			return  indexOf(arr, target, mid + 1, hi);
		} else if (arr[mid].compareTo(target) > 0) {
			CompCount++;
			return  indexOf(arr, target, lo, mid - 1);
		} else {
			CompCount++;
			return mid;
		}
    }

 /**
       Places all permutations of s into strings.
       
       @param prefix will be concatenated to the permutations of s to
       form new strings.
	   @param s The target string that is compared against
       @param strings will contain all strings of length
       (prefix.length + s.length).  They are added in the base case of
       perm.

    */
    private static void perm(String prefix,String s, ArrayList<String> strings) {
		int n = s.length();
		CompCount++;
		if (n == 0) { strings.add(prefix + s); } // THE BASE CASE
		else {
			for (int i = 0; i < n; i++) // RECURSIVELY SHIFTING LETTERS OVER, IN MAIN COMPARED AGAINST DICT
			{
				perm(prefix + s.charAt(i),
					s.substring(0, i) + s.substring(i + 1), strings);
			}
		}
    }
    
    /**
       Return ArrayList of all permutations of s.
    */
    public static ArrayList<String> permutations(String s) {
		ArrayList<String> strings = new ArrayList<String>();
		perm("",s,strings);
		return strings;
    }

	/**
	 * Uses the QuickSort algorithm to sort an array of strings in lexicographical order.
	 * @param s String that will be split and then sorted
	 * @return The now joined again string, in order
	 */
	public static String sortLetters(String s) {
		String StringArray[] = s.split("");
		QuickSort.quickSort(StringArray);

		s = String.join("", StringArray);

		return s;
	}

	/**
	 * An implementation of the QuickSort algorithm we discussed in class. I used it for this lab
	 * to be bale to sort both the string arrays that I segmented from the individual words; and
	 * the sorted dictionary.txt that is imported. Not generic as I needed it for a specific purpose.
	 * Also, to fit with theme of the lab it is in fact recursive.
	 *
	 * @author HENRY WANDOVER
	 */
	public class QuickSort {
		public static long CompCount;

		/**
		 * Checks if there are items in array, if so begins recursion by calling the partition method which recurses itself.
		 *
		 * @param a String array input
		 */
		public static void quickSort(String a[]) {
			CompCount++;
			if (a == null || a.length == 0) return;
			partition(a, 0, a.length - 1);
		}


		/**
		 * Establishes a pivot and moves items to right or left side depending if they are
		 * lexicographically greater or less than the pivot string.
		 *
		 * @param a String array input
		 * @param lo the lower index of array
		 * @param hi the upper index of array
		 */
		private static void partition(String a[], int lo, int hi) {
			int i = lo, j = hi;
			String pivot = a[lo];

			while (i <= j) {
				CompCount++;
				while (a[i].compareTo(pivot) < 0) {
					CompCount++;
					i++;
				}
				CompCount++;

				while (a[j].compareTo(pivot) > 0) {
					CompCount++;
					j--;
				}
				CompCount++;

				CompCount++;
				if (i <= j) {
					exch(a, i, j);
					i++;
					j--;
				}
			}
			CompCount++;

			// CALLS AGAIN THE PARTITION METHOD
			CompCount++;
			if (lo < j) { partition(a, lo, j); }
			CompCount++;
			if (i < hi) { partition(a, i, hi); }
		}

		/**
		 * Swaps the indices in a given array.
		 *
		 * @param a Array input
		 * @param i First index
		 * @param j Second index
		 */
		private static void exch(String a[], int i, int j) {
			String temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}

	/**
       Looks up all permutations of a string in the dictionary.
   		USAGE: java SpellCheck src/dictionary.txt jumbled_letters

     */
    public static void main(String[] args)
	throws FileNotFoundException, IOException {
		int minlen;
		String dictionaryFile = args[0];
		String letters = args[1];
		ArrayList words = new ArrayList();

		SpellCheck checker = new SpellCheck(dictionaryFile);



		// UNSORTED, CHECKS IF WORD IS FOUND IN DICTIONARY FILE
		long startTime = System.currentTimeMillis();
		int indexOf = checker.indexOf(letters, false);
		CompCount++;
		if (indexOf == SpellCheck.NOT_FOUND)
			System.out.println("Not found: "  + letters);
		else
			System.out.println("Position of " +  letters + " in dictionary " +
					   indexOf + " " + checker.get(indexOf));
		long endTime = System.currentTimeMillis();
		System.out.println("Comparisons made: " + CompCount);
		CompCount = 0;
		System.out.println("That took " + (endTime - startTime) + " milliseconds");

		// RUNS PERMUTATIONS METHODS TO FIND ALL VALID WORDS MADE FROM A JUMBLE
		startTime = System.currentTimeMillis();
		for (String s : checker.permutations(letters)) {
			indexOf = checker.indexOf(s, false);
			CompCount++;
			if (indexOf != SpellCheck.NOT_FOUND) words.add(s);
		}
		endTime = System.currentTimeMillis();
		System.out.println("Permutations:" + " " + words);
		System.out.println("Comparisons made: " + CompCount);
		CompCount = 0;
		System.out.println("That took " + (endTime - startTime) + " milliseconds");

		// SORTED, CHECKS IF WORD IS FOUND IN A SORTED VERSION OF DICTIONARY,
		// COMPARING TO THE SORTED TARGET W/ QUICKSORT
		startTime = System.currentTimeMillis();
		indexOf = checker.indexOf(letters, true);
		CompCount++;
		if (indexOf == SpellCheck.NOT_FOUND)
			System.out.println("Not found: "  + letters);
		else
			System.out.println("Position of " +  letters + " in dictionary " +
					indexOf + " " + checker.get(indexOf));
		endTime = System.currentTimeMillis();
		CompCount = CompCount + QuickSort.CompCount;
		System.out.println("Comparisons made: " + CompCount);
		System.out.println("That took " + (endTime - startTime) + " milliseconds");

    }

	/*
	I did the extra credit and as running the main method shows,
	the sorting based method is significantly slower at finding
	the jumbled word. With that there is much more in involved. I have
	to sort every individual string, as well as now resort the dict file
	so it's in lexicographic order and can then be searched through with
	indexOf. Where instead the recursive anagram has an easier task of
	creating every permutation and then searching for each one. Although,
	both are sufficient in what they do and at least it's not an insane
	difference. Recursive took 38 ms and had 38,043 comparisons on one run and
	Sorting took 2,482 ms and made 67,988,436 comparisons.
	*/

}