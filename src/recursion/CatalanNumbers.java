package recursion;

//https://www.youtube.com/watch?v=2NZF2UKyh0g
public class CatalanNumbers {
	private static int count = 0;

	public static void main(String[] args) {
		int N = 108;
		System.out.println("count of binary trees with n nodes :" + catalan(N));
		System.out.println("count: " + count);
	}

	private static int catalan(int n) {

		if (n <= 1) {
			return 1;
		}

		System.out.println(n);
		int result = 0;
		for (int i = 0; i < n; i++) {
			count++;

			result = result + catalan(i) * catalan(n - i - 1);
		}
		return result;
	}
}
