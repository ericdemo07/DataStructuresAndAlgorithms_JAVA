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

	// private static int findSum(int[] arr) {
	// int maxSum = 0;
	//
	// for (int i = 0; i < arr.length; i++) {
	// int currentSum = 0;
	// for (int j = i; j < arr.length; j++) {
	// currentSum = currentSum + arr[j];
	// System.out.println("current sum1 :" + currentSum + " : maxsum : " + maxSum);
	//
	// if (currentSum > maxSum) {
	// maxSum = currentSum;
	// }
	// }
	// System.out.println("current sum2 :" + currentSum);
	// }
	// return maxSum;
	// }

}
