package array;

public class Rotation {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int k = 3;

		// for multiple right rotations i.e k1 = 1, k2 = 5, k3 = 6, k4 = 4
		// do k = (k1+k2+k3+k4)%arr.length

		Rotation dummyPad = new Rotation();
		dummyPad.leftRotation(arr, k);

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	private void leftRotation(int[] arr, int k) {
		rotate(arr, k);
	}

	private void rightRotation(int[] arr, int k) {
		rotate(arr, arr.length - k);
	}

	private void rotate(int[] arr, int k) {
		reverse(arr, 0, k - 1);
		reverse(arr, k, arr.length - 1);
		reverse(arr, 0, arr.length - 1);
	}

	private void reverse(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;

			start = start + 1;
			end = end - 1;
		}
	}
}
