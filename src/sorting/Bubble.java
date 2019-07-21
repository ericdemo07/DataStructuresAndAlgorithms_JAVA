package sorting;

//https://www.youtube.com/watch?v=Jdtq5uKz-w4
public class Bubble {

	public static void main(String... args) {
		int[] arr = { 4, 2, 1, 3, 8, 6, 7, 9, 5 };
		sort(arr);

		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}

	private static void sort(int[] arr) {
		int count = 0;

		// bubble sort best case can be improved to O(n) using this swapped variable
		// which will stop after one iteration if array is already sorted
		boolean swapped = true;
		for (int j = 0; j < arr.length && swapped; j++) {
			for (int i = 0; i < arr.length - j - 1; i++) {
				swapped = false;
				count++;
				if (arr[i] > arr[i + 1]) {
					swapped = true;
					int temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
		}
		System.out.println(count);
	}
}
