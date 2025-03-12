/**
 * Compares running time of naive and optimized implementations
 * of some recursive methods.
 */
public class RecursiveMethodComparison {

	public static void main(String[] args) {
		StopWatch sw = new StopWatch();

		//Print header
		System.out.printf("%-81s%s\n", "METHOD", "TIME IN NANOSECONDS");
		for(int i=0; i<100; i++) {
			System.out.print("-");
		}
		System.out.println();

		//Compare powerN
		System.out.printf("%-75s", "Recursion.powerN(2, 31): ");
		sw.start();
		Recursion.powerN(2, 31);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());

		System.out.printf("%-75s", "OptimizedRecursion.powerN(2, 31): ");
		sw.start();
		OptimizedRecursion.powerN(2, 31);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());

		System.out.printf("%-75s", "Math.pow(2, 31): ");
		sw.start();
		Math.pow(2, 31);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());
		System.out.println();

		//Compare harmonicSum
		System.out.printf("%-75s", "Recursion.harmonicSum(5000): ");
		sw.start();
		Recursion.harmonicSum(5000);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());

		System.out.printf("%-75s", "OptimizedRecursion.harmonicSum(5000): ");
		sw.start();
		OptimizedRecursion.harmonicSum(5000);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());
		System.out.println();

		//Compare reverseDisplay
		System.out.printf("%-65s", "Recursion.reverseNumber(Integer.MAX_VALUE): ");
		sw.start();
		Recursion.reverseNumber(Integer.MAX_VALUE);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());

		System.out.printf("%-65s", "OptimizedRecursion.reverseNumber(Integer.MAX_VALUE): ");
		sw.start();
		OptimizedRecursion.reverseNumber(Integer.MAX_VALUE);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());
		System.out.println();

		//Compare contains
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < 100; i++) {
			sb.append('a');
		}
		String s = sb.toString();
		System.out.println("(Note: s is a string of 1000 characters 'a')");

		System.out.printf("%-75s", "Recursion.contains('b', s): ");
		sw.start();
		Recursion.contains('b', s);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());

		System.out.printf("%-75s", "OptimizedRecursion.contains('b', s): ");
		sw.start();
		OptimizedRecursion.contains('b', s);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());

		System.out.printf("%-75s", "s.contains(\"b\"): ");
		sw.start();
		s.contains("b");
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());
		System.out.println();


		//Compare numOccurences
		System.out.println("(Note: s is a string of 1000 characters 'a')");

		System.out.printf("%-75s", "Recursion.numOccurences('a', s): ");
		sw.start();
		Recursion.numOccurences('a', s);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());

		System.out.printf("%-75s", "OptimizedRecursion.numOccurences('a', s): ");
		sw.start();
		OptimizedRecursion.numOccurences('a', s);
		sw.stop();
		System.out.printf("%,25d\n", sw.getElapsedTime());
		System.out.println();
	}

}

class StopWatch {
	private long startTime;
	private long endTime;

	StopWatch() {
		startTime = System.nanoTime();
	}

	void start() {
		startTime = System.nanoTime();
	}

	void stop() {
		endTime = System.nanoTime();
	}

	long getElapsedTime() {
		return endTime - startTime;
	}
}
