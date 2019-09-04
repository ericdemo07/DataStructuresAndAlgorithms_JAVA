package array;

//Given an array of integers nums and an int k. Return the product of every k consecutive numbers.

public class ProductOfKConsecutive {

	public static void main(String[] args) {

		int[] arr = { 1, 3, 3, 6, 5, 7, 0, -3 };
		int k = 3;

		arr = process(arr, k);

		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}

	private static int[] process(int[] arr, int k) {
		int[] arr1 = new int[arr.length];

		for (int i = arr.length - 1; i >= 0; i--) {
			int prod = 1;
			int j = 0;

			while (j != k && i >= j) {
				prod = prod * arr[i - j];
				j = j + 1;
			}
			arr1[i] = prod;
		}

		return arr1;
	}
}
