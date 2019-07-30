package dynamicprogramming;

public class LongestCommonSubsequence {
	static int count = 0;

	public static void main(String[] args) {
		char[] temp1 = { 'a', 'e', 'i', 'o', 'u' };
		char[] temp2 = { 'e', 'o', 'u' };

		int[][] memo = new int[temp1.length + 1][temp2.length + 1];

		// i am doubtful is not this takes O(n2) time
		for (int row = 0; row < temp1.length + 1; row++) {
			for (int col = 0; col < temp2.length; col++) {
				memo[row][col] = -1;
			}
		}

		System.out.println("LCS :" + LCS(0, temp1, 0, temp2, memo));

		// System.out.println("bottomUp :" + bottomUp(temp1, temp2));

		System.out.println("count :" + count);
	}

	private static int LCS(int i, char[] temp1, int j, char[] temp2, int[][] memo) {
		if (memo[i][j] >= 0) {
			return memo[i][j];
		}
		count++;

		if (i == temp1.length || j == temp2.length) {
			return 0;
		} else if (temp1[i] == temp2[j]) {
			int result = 1 + LCS(i + 1, temp1, j + 1, temp2, memo);
			memo[i][j] = result;
			return result;
		}
		int result = Math.max(LCS(i, temp1, j + 1, temp2, memo), LCS(i + 1, temp1, j, temp2, memo));
		memo[i][j] = result;
		return result;
	}

	private static int bottomUp(char[] temp1, char[] temp2) {
		int[][] memo = new int[temp1.length + 1][temp2.length + 1];

		for (int row = 0; row < temp1.length; row++) {
			for (int col = 0; col < temp2.length; col++) {
				if (temp1[row] == temp2[col]) {
					memo[row + 1][col + 1] = 1 + memo[row + 1 - 1][col + 1 - 1];
				} else {
					memo[row + 1][col + 1] = Math.max(memo[row + 1 - 1][col + 1], memo[row + 1][col + 1 - 1]);
				}
			}
		}

		return memo[temp1.length][temp2.length];
	}
}
