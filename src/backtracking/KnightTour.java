package backtracking;

/*
 * https://www.geeksforgeeks.org/the-knights-tour-problem-backtracking-1/
 * https://www.youtube.com/watch?v=DKCbsiDBN6c
 */
public class KnightTour {

	private static final int N = 8;

	// this is important xMove and yMove together makes all move a knight can make
	// (viz. all 2 and half steps)
	private static final int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
	private static final int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };

	public static void main(String[] args) {
		KnightTour knightTour = new KnightTour();
		knightTour.solve();
	}

	private void solve() {
		// creating matrix
		int sol[][] = new int[N][N];

		// initializing matrix
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				sol[x][y] = -1;
			}
		}
		// knight initial state
		sol[0][0] = 0;

		if (!solveUtil(0, 0, 1, sol)) {
			System.out.println("Solution does not exist");
		} else {
			printSolution(sol);
		}
	}

	private boolean solveUtil(int x, int y, int movei, int sol[][]) {

		int k, next_x, next_y;

		if (movei == N * N) {
			return true;
		}

		for (k = 0; k < 8; k++) {
			next_x = x + xMove[k];
			next_y = y + yMove[k];

			// System.out.println("x :" + next_x + " y :" + next_y);
			if (isSafe(next_x, next_y, sol)) {
				sol[next_x][next_y] = movei;
				if (solveUtil(next_x, next_y, movei + 1, sol)) {
					return true;
				} else {
					System.out.println("nice move ");
					sol[next_x][next_y] = -1;// backtracking
				}
			}
		}

		return false;
	}

	private boolean isSafe(int x, int y, int sol[][]) {

		return (x >= 0 && x < N && y >= 0 && y < N && sol[x][y] == -1);

	}

	private void printSolution(int sol[][]) {
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				System.out.print(sol[x][y] + " ");
			}
			System.out.println();
		}
	}
}
