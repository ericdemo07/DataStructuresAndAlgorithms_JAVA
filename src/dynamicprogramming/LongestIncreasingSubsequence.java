package dynamicprogramming;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = { 3, 4, -1, 0, 6, 2, 3, 0 };

		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		System.out.println(lis.bottomUp(arr));

	}

	// next two method under costruction
	private int LIS(int[] arr) {

		return LISUtil(0, 1, arr);
	}

	private int LISUtil(int i, int j, int[] arr) {
		if (j == arr.length) {
			return 0;
		}
		if (i == j - 1) {
			return LISUtil(0, j + 1, arr);
		}
		if (arr[i] < arr[j]) {
			return 1 + LISUtil(i + 1, j, arr);
		}
		return LISUtil(i + 1, j, arr);
	}

	private int bottomUp(int[] arr) {
		int[] lis = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			lis[i] = 1;
		}
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[i] + 1;
				}
			}
		}
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (lis[i] > max) {
				max = lis[i];
			}
		}

		return max;
	}

}
