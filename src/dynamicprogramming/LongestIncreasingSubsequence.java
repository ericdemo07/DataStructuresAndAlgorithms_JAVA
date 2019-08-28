package dynamicprogramming;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		int[] arr = { 3, 4, -1, 0, 6, 2, 3, 0 };

		LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
		// System.out.println(lis.bottomUp(arr));
		lis.lis(arr);
		System.out.println(count);
	}

	static int count = 0;

	public int lis(int arr[]) {
		int maxLen = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			int len = lisUtil(arr, i + 1, arr[i]);
			System.out.println(len);

			if (len > maxLen) {
				maxLen = len;
			}
		}
		return maxLen + 1;
	}

	private int lisUtil(int arr[], int i, int lastNum) {
		count++;
		if (i == arr.length) {
			return 0;
		}
		int t1 = 0;
		if (arr[i] > lastNum) {
			t1 = 1 + lisUtil(arr, i + 1, arr[i]);
		}
		int t2 = lisUtil(arr, i + 1, lastNum);
		return Math.max(t1, t2);
	}

	private int bottomUp(int[] arr) {
		int[] lis = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			lis[i] = 1;
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
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
