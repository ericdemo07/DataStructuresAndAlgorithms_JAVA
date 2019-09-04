package array;

public class CountOfTripletsThatFormAP {
	public static void main(String[] args) {
		int[] arr = { 2, 6, 9, 12, 17, 22, 31, 32, 35, 42 };

		CountOfTripletsThatFormAP dummyPad = new CountOfTripletsThatFormAP();
		dummyPad.triplets(arr);
	}

	private void triplets(int[] arr) {
		int count = 0;

		for (int i = 1; i < arr.length - 1; i++) {

			int j = i - 1;
			int k = i + 1;

			while (j >= 0 && k <= arr.length - 1) {
				int sum = arr[j] + arr[k];
				if (sum == 2 * arr[i]) {
					count = count + 1;
					j = j - 1;
					k = k + 1;
				} else if (sum < 2 * arr[i]) {
					k = k + 1;
				} else {
					j = j - 1;
				}
			}
		}
		System.out.println(count);
	}
}
