package array;

//simple array rotation is left rotation
public class LeftRotation {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int k = 3;

		reverse(arr, k, arr.length - 1);
		reverse(arr, 0, k - 1);
		reverse(arr, 0, arr.length - 1);

		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}

	private static void reverse(int[] arr, int start, int end) {

		while (start < end) {
			int temp = arr[end];
			arr[end] = arr[start];
			arr[start] = temp;

			start++;
			end--;
		}
	}

}
