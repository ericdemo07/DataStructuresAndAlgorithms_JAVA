package recursion;

public class Factorial {

	public static void main(String... args) {

		int n = 3;

		System.out.println(findRecursively(n));
	}

	private static int findRecursively(int n) {
		if (n == 0) {
			return 1;
		} else {
			return n * findRecursively(n - 1);
		}
	}

	private static int findIteratively(int n) {

		int fact = n;

		while (n > 1) {
			fact = fact * (n - 1);
			n--;
		}

		return fact;
	}
}
