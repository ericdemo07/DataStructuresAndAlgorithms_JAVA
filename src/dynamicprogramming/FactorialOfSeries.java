package dynamicprogramming;

public class FactorialOfSeries {

	public static void main(String[] args) {

		int M = 5;
		int N = 4;

		int[] memo = new int[M + 1];

		System.out.println("fact: " + findFact(M, memo));

		System.out.println("fact: " + findFact(N, memo));
	}

	private static int findFact(int n, int[] memo) {

		if (memo[n] != 0) {
			return memo[n];
		}

		if (n < 2) {
			return n;
		}

		int result = n * findFact(n - 1, memo);
		memo[n] = result;

		return result;

	}

}
