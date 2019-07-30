package dynamicprogramming;

//https://www.youtube.com/watch?v=vYquumk4nWw
public class Fibonacci {

	public static void main(String[] args) {

		int N = 6;
		int[] memo = new int[N + 1];

		// System.out.println(findNth(N, memo));
		System.out.println(bottumUp(N));
	}

	private static int findNth(int n, int[] memo) {
		if (memo[n] != 0) {
			return memo[n];
		}
		if (n < 2) {
			return n;
		}
		int result = findNth(n - 1, memo) + findNth(n - 2, memo);
		memo[n] = result;
		return result;
	}

	private static int bottumUp(int n) {
		if (n < 2) {
			return n;
		}
		int[] bottomUp = new int[n + 1];
		bottomUp[1] = 1;
		bottomUp[2] = 1;

		for (int i = 3; i <= n; i++) {
			bottomUp[i] = bottomUp[i - 1] + bottomUp[i - 2];
		}

		return bottomUp[n];
	}
}
