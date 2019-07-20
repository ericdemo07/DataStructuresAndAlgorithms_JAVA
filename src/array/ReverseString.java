package array;

public class ReverseString {

	public static void main(String... args) {

		char[] arr = { 'h', 'e', 'l', 'l', 'o' };

		reverse(arr);

		for (char c : arr) {
			System.out.print(c + "\t");
		}

	}

	private static void reverse(char[] arr) {
		int i = 0;
		int j = arr.length - 1;
		char temp = 0;

		while (i <= j) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
}
