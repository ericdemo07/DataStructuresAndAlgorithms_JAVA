package array;

public class RightRotation {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 9 };
		int k1 = 1;
		int k2 = 3;
		int k3 = 4;
		int k4 = 6;

		int k = (k1 + k2 + k3 + k4) % arr.length;

		// trick between left and right
		int l = arr.length - k;

		reverse(arr, l, arr.length - 1);
		reverse(arr, 0, l - 1);
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
