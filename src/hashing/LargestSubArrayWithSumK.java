package hashing;

import java.util.*;

public class LargestSubArrayWithSumK {
	public static void main(String[] args) {
		int[] arr = { 15, -2, 2, -8, 1, 7, 10, 23 };

		LargestSubArrayWithSumK dPad = new LargestSubArrayWithSumK();
		dPad.largestSubArrayWithSumK(arr, 33);
	}

	private void largestSubArrayWithSumK(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		int sum = 0;
		int maxLength = 0;

		for (int i = 0; i < arr.length; i++) {
			sum = sum + arr[i];
			if (sum == k) {
				maxLength = i + 1;
			}
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
			if (map.containsKey(sum - k)) {
				maxLength = Math.max(maxLength, i - map.get(sum - k));
			}
		}
		System.out.println(maxLength);
	}
}
