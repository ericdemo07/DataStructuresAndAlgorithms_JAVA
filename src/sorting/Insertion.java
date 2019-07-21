package sorting;

//https://www.youtube.com/watch?v=i-SKeOcBwko
public class Insertion {

	public static void main(String[] args) {
		int[] arr = { 4, 2, 1, 3, 8, 6, 7, 9, 5 };
		sort(arr);

		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}

	private static void sort(int[] arr) {
		int count = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			int index = i;
			int value = arr[index + 1];

			while (index >= 0 && arr[index] > value) {
				count++;
				int temp = arr[index + 1];
				arr[index + 1] = arr[index];
				arr[index] = temp;
				index--;
			}
		}
		System.out.println(count);
	}
}
