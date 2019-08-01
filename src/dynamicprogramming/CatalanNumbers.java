package dynamicprogramming;

//https://www.youtube.com/watch?v=2NZF2UKyh0g
public class CatalanNumbers {
	static int count = 0;

	public static void main(String[] args) {
		int N = 5;
		int[] memo = new int[N + 1];

		System.out.println("count of binary trees with n nodes :" + catalan(N, memo));

		// System.out.println("get catalan by formula :" + catalanByFormula(N));
		System.out.println("count: " + count);

		// memo will contain catalin numbers
		// memo[0] = memo[1] = 1;
		// for (int i = 0; i < memo.length; i++) {
		// System.out.println("catalin i : "+i+" , n : "+memo[i]);
		// }
	}

	private static int catalan(int n, int[] memo) {

		if (n <= 1) {
			return 1;
		}

		if (memo[n] != 0) {
			return memo[n];
		}

		System.out.println(n);
		int result = 0;
		for (int i = 0; i < n; i++) {
			count++;
			result = result + catalan(i, memo) * catalan(n - i - 1, memo);
		}

		memo[n] = result;

		return result;
	}

	private static int catalanByFormula(int n) {
		// (2n)!/((n+1)!n!)

		int[] memo = new int[2 * n + 1];

		int catalan = getFactorial(2 * n, memo) / ((getFactorial(n + 1, memo)) * getFactorial(n, memo));
		return catalan;
	}

	private static int getFactorial(int n, int[] memo) {

		if (memo[n] != 0) {
			return memo[n];
		}

		if (n == 0) {
			return 1;
		}
		count++;
		int result = n * getFactorial(n - 1, memo);
		memo[n] = result;

		return result;
	}
}
