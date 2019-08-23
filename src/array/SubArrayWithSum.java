package array;

import java.util.Arrays;
import java.util.Scanner;

public class SubArrayWithSum {
	public static void main(String... args) {
		SubArrayWithSum subArray = new SubArrayWithSum();
		Scanner in = new Scanner(System.in);
		String countAsString = in.nextLine();
		int count = Integer.parseInt(countAsString);
		int[][] qArr = new int[2][count];
		for (int i = 0; i < count; i++) {
			String input = in.nextLine();
			int[] arr1 = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
			input = in.nextLine();
			int[] arr2 = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
			int[] q = subArray.findSubArray(arr2, arr1[1]);
			qArr[i] = q;
		}

		for (int[] q : qArr) {
			System.out.println();
			for (int j : q) {
				System.out.print(j + " ");
			}
		}

	}

	private int[] findSubArray(int[] arr, int sum) {
		int[] res = new int[2];
		for (int i = 0; i < arr.length; i++) {
			res[1] = i;
			sum = sum - arr[i];
			if (sum == 0) {
				break;
			}
			while (sum < 0) {
				sum = sum + arr[res[0]];
				res[0] = res[0] + 1;
			}
			if (sum == 0) {
				break;
			}
		}
		res[0] = res[0] + 1;
		res[1] = res[1] + 1;

		return res;
	}
}
