package sorting;

public class SortCheck {

	public static void main(String[] args) {
		// int[] arr = { 4, 2, 1, 3, 8, 6, 7, 9, 5 };
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		// boolean isSorted = recursion(arr, arr.length - 1);
		boolean isSorted = iterative(arr);

		System.out.println(isSorted);
	}

	private static boolean recursion(int[] arr, int index) {

		if (arr.length == 0 || index == 0) {
			return true;
		}
		return (arr[index] > arr[index - 1] ? recursion(arr, index - 1) : false);
	}

	private static boolean iterative(int[] arr) {

		boolean isSorted = true;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				isSorted = false;
			}
		}
		return isSorted;
	}
}
