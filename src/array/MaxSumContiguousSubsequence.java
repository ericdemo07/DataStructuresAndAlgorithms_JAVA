package array;

//Kadane's algo - https://www.youtube.com/watch?v=86CQq3pKSUw
public class MaxSumContiguousSubsequence {

	public static void main(String[] args) {
		int[] arr = { -1, 3, 4, -5, 6, 7, -3, 2 };

		MaxSumContiguousSubsequence dummyPad = new MaxSumContiguousSubsequence();
		dummyPad.maxSumContiguous(arr);
	}

	public void maxSumContiguous(int[] arr) {
		int maxSum = arr[0];
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum = Math.max(sum + arr[i], arr[i]);
			maxSum = Math.max(maxSum, sum);
		}

		System.out.println(maxSum);
	}
}
