package array;

import java.util.Scanner;
import java.util.Arrays;

public class DummyPad {
	public static void main(String... args) {
		DummyPad subArray = new DummyPad();
		final Scanner in = new Scanner(System.in);
		int count = in.nextInt();

		while (count > 0) {
			int n = in.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			subArray.triplets(arr);
			count = count - 1;
		}
	}

	private void triplets(int[] arr) {
		Arrays.sort(arr);
		int count = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			int j = 0;
			int k = i - 1;

			while (j < k) {
				int sum = arr[j] + arr[k];
				if (arr[i] == sum) {
					count = count + 1;
					j = j + 1;
					k = k - 1;
				} else if (sum < arr[i]) {
					j = j + 1;
				} else {
					k = k - 1;
				}
			}
		}
		count = count > 0 ? count : -1;
		System.out.println(count);
	}
}
