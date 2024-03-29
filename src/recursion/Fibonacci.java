package recursion;

//this prints sum of of fibonacci numbers (0,1,1,2,3,5,8,13...) inside given limit
public class Fibonacci {

	public static void main(String... args) {
		int limit = 41;

		// System.out.println(findSum(0, 1, limit));
		System.out.println(findNth(6));
	}

	private static int findSum(int a, int b, int limit) {
		if (b + a > limit) {
			return 0;
		} else {
			return a + findSum(b, b + a, limit);
		}
	}

//https://www.youtube.com/watch?v=zg-ddPbzcKM	
	private static int findNth(int n) {
		if (n < 2) {
			return n;
		}
		return findNth(n - 1) + findNth(n - 2);
	}
}
