/**
 * In theory the methods contained in this class are optimized versions
 * of methods in Recursion.
 *
 * Run CompareImplementations to see how much time the optimized versions
 * save in practice.
 *
 *
 *
 */
public class OptimizedRecursion {

	/**
	 * Q1: tail-recursive method that computes x^n for a positive
	 *     integer n.
	 */
	public static int powerN (int x, int n) {
		if (n == 0)
			return 1;
		else
			return powerN(x, n, x);
	}

	/** helper method */
	private static int powerN (int x, int n, int accumulator) {
		if (n == 1)
			return accumulator;
		else
			return powerN(x, n - 1, x*accumulator);
	}

	/**
	 *  Q2: tail-recursive method that computes the following series
	 *      S = 1 + 1/2 + 1/3 + ...+1/ n
	 */
	public static double harmonicSum(int n) {
		return harmonicSum(n, 1);
	}

	/** helper method */
	private static double harmonicSum(int n, double accumulator) {
		if (n == 1)
			return accumulator;
		else
			return harmonicSum(n - 1, accumulator + 1.0/n);
	}


	/**
	 *  Q3: recursive method that displays an int value reversely
	 *      on the console
	 *
	 *      Can't think of how to optimize this one other than
	 *      making it iterative... In this case adding a helper
	 *      would make it take more resources.
	 */
	public static void reverseNumber(int value){
		if ((value % 10) == value) {
			System.out.print(value);
		}
		else {
			System.out.print(value % 10);
			reverseNumber(value/10);
		}
	}

	/**
	 * Q5: recursive method that returns true if the String contains the char,
	 *     otherwise returns false
	 */
	public static boolean contains(char c, String s){
			if(s == null || s.length() == 0)
				return false;
      else
				return contains(c, s, s.length() - 1);
	}

	/** helper - saves memory by keeping track of index instead of creating
	 *  new String objects at each recursive step
	 */
	private static boolean contains(char c, String s, int index){
		if (index == 0)
			return (s.charAt(0) == c);
		else
			return (s.charAt(index) == c) || contains(c, s, index - 1);
	}

	/**
	 * Q5: tail - recursive method that returns the number of characters in the
	 *     String, which may be 0
	 */
	public static int numOccurences(char c, String s) {
		if (s == null)
			return 0;
		else
			return  recursiveCount(c, s, 0, 0);
	}

	/** helper - doubly helpful, as it keeps track of index instead of creating
	 *  new String objects at each recursive step, and accumulates the count.
	 */
	public static int recursiveCount(char c, String s, int index, int accumulator) {
		if (index == s.length()) {
			return accumulator;
		}
		else {
			return  recursiveCount(c, s, index+1,
															accumulator + (s.charAt(index) == c? 1 : 0));

		}
	}

	public static void main(String[] args) {
		/////////////////////// TESTS FOR Q1 ///////////////////////////////////
		System.out.println("---------- Q1 X^N ------------------------------");
		System.out.println("powerN(2, 0) is " + powerN(2,0));
		System.out.println("powerN(2, 1) is " + powerN(2,1));
		System.out.println("powerN(2, 5) is " + powerN(2,5));
		System.out.println();

		/////////////////////// TESTS FOR Q2  //////////////////////////////////
		System.out.println("---------- Q2 HARMONIC SERIES ------------------");
		System.out.println("harmonicSum(1) is " + harmonicSum(1));
		System.out.println("harmonicSum(2) is " + harmonicSum(2));
		System.out.println("harmonicSum(5) is " + harmonicSum(5));
		System.out.println();

		/////////////////////// TESTS FOR Q3  //////////////////////////////////
		System.out.println("---------- Q3 REVERSE INT ----------------------");
		System.out.print("reverseNumber(1) is "); reverseNumber(1);
		System.out.print("\nreverseNumber(12) is "); reverseNumber(12);
		System.out.print("\nreverseNumber(123) is "); reverseNumber(123);
		System.out.println("\n");

		/////////////////////// TESTS FOR Q4  //////////////////////////////////
		System.out.println("---------- Q4 STRING CONTAINS CHAR -------------");
		System.out.println("contains('a', null) is "
						  + contains('a', null));
		System.out.println("contains('a',\"\") is "
		                  + contains('a', ""));
		System.out.println("contains('a', \"a\") is "
						  + contains('a', "a"));
		System.out.println("contains('a', \"b\") is "
				          + contains('a', "b"));
		System.out.println("contains('a', \"ab\") is "
						  + contains('a', "ab"));
		System.out.println("contains('a', \"ba\") is "
				          + contains('a', "ba"));
		System.out.println("contains('a', \"bcabx\") is "
				          + contains('a', "bcabx"));
		System.out.println("contains('x', \"bcbz\") is "
				          + contains('x', "bcbz"));
		System.out.println();



		/////////////////////// TESTS FOR Q5  //////////////////////////////////
		System.out.println("---------- Q5 CHAR COUNT  ----------------------");
		System.out.println("numOccurences('a', null) is "
						  + numOccurences('a', null));
		System.out.println("numOccurences('a',\"\") is "
		                  + numOccurences('a', ""));
		System.out.println("numOccurences('a', \"a\") is "
						  + numOccurences('a', "a"));
		System.out.println("numOccurences('a', \"b\") is "
				          + numOccurences('a', "b"));
		System.out.println("numOccurences('a', \"ab\") is "
						  + numOccurences('a', "ab"));
		System.out.println("numOccurences('a', \"ba\") is "
				          + numOccurences('a', "ba"));
		System.out.println("numOccurences('a', \"bcabx\") is "
				          + numOccurences('a', "bcabx"));
		System.out.println("numOccurences('x', \"bcbz\") is "
				          + numOccurences('x', "bcbz"));
		System.out.println("numOccurences('x', \"xyxyyyyxx\") is "
		                  + numOccurences('x', "xyxyyyyxx"));
		System.out.println();
	}

}
