package array;

//Kadane's algo - https://www.youtube.com/watch?v=86CQq3pKSUw
public class MaximumSumContiguousSubsequence {

	public static void main(String[] args) {
		int[] arr = { -1, 3, 4, -5, 6, 7, -3, 2 };

		System.out.println("sum :" + findSum(arr));
	}

	private static int findSum(int[] arr) {
		int maxSum = arr[0], sum = Integer.MIN_VALUE / 2;// think

		for (int i = 0; i < arr.length; i++) {
			sum = Math.max(sum + arr[i], arr[i]);
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}
}
