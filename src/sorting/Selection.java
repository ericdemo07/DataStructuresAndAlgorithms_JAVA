package sorting;

//https://www.youtube.com/watch?v=xWBP4lzkoyM
public class Selection {

	public static void main(String... args) {
		int[] arr = { 4, 2, 1, 3, 8, 6, 7, 9, 5 };
		sort(arr);

		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}

	private static void sort(int[] arr) {
		int count = 0;
		for (int j = 0; j < arr.length; j++) {
			int low = arr[j];
			int index = j;

			for (int i = j; i < arr.length - 1; i++) {
				count++;
				if (arr[i + 1] < low) {
					low = arr[i + 1];
					index = i + 1;
				}
			}

			int temp = arr[j];
			arr[j] = arr[index];
			arr[index] = temp;
		}
		System.out.println("count:" + count);
	}
}
