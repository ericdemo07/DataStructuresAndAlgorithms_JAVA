package matrix;

public class MatrixMultiplication {

	public static void main(String[] args) {

		int[][] A = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] B = { { 1, 2 }, { 3, 4 }, { 5, 6 } };

		multiply(A, B);

	}

	private static int[][] multiply(int[][] A, int[][] B) {

		int[][] M = new int[A.length][B[0].length];
		int i = 0;

		for (int row = 0; row < A.length; row++) {
			int sum = 0;
			for (int col = 0; col < A[row].length; col++) {

				sum = sum + A[row][col] * B[col][row];
				System.out.println("row: " + row + "   col: " + col + "      :     " + A[row][col] + " " + B[col][row]);

				for (int k = 0; k < 2; k++) {
					System.out.println("k :" + k);
				}
			}
			// System.out.println("row: " + row + " sum: " + sum);
		}

		return A;
	}

}
