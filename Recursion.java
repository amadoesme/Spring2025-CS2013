
/**
 * Solutions to recursion practice.
 */

public class Recursion {


	/**
	 * Q1: recursive method that computes x^n for positive integers x, n
	 */
	public static int powerN (int x, int n) {
		if (n == 0)
			return 1;
		else
			return  x * powerN(x, n - 1);
	}

	/**
	 *  Q2: recursive method that computes the following series
	 *      S = 1 + 1/2 + 1/3 + ...+1/ n
	 */
	public static double harmonicSum(int n) {
		if (n == 1)
			return 1;
		else
			return 1.0/n + harmonicSum(n - 1);
	}


	/**
	 *  Q3: recursive method that displays an int value reversely
	 *      on the console
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
	 * Q4: recursive method that returns true if the String contains the char,
	 *     otherwise returns false
	 */
	public static boolean contains(char c, String s){
		if (s == null || s.isEmpty())
		 	return false;
		else
			return s.charAt(0) == c || contains(c, s.substring(1));
	}

	/**
	 * Q5: recursive method that returns the number of occurences of char c in
	 *     String s.
	 */
	public static int numOccurences(char c, String s) {
		if (s == null || s.isEmpty())
			return 0;
		else
			return  (s.charAt(0) == c? 1 : 0) + numOccurences(c, s.substring(1));
	}

	// public static void terneryOperatorDemo() {
	// 	int i = (int)(Math.random() * 100);
	// 	System.out.println((i % 2 == 0)? "even": "odd");
	//
	// 	int k = (i > 70)? 1 : 0;
	// }

	public static void main(String[] args) {

		/////////////////////// TESTS FOR Q1 ///////////////////////////////////
		System.out.println("---------- Q1 X^N ------------------------------");
		System.out.println("powerN(2, 0) is " + powerN(2,0));
		System.out.println("powerN(2, 1) is " + powerN(2,1));
		System.out.println("powerN(-2, 3) is " + powerN(-2,3));
		System.out.println("powerN(-2, 4) is " + powerN(-2,4));
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
