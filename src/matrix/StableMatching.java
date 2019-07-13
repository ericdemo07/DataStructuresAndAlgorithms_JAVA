package matrix;

public class StableMatching {
	// Gale Shapley Algorithm
	private static int prefer[][] = { { 7, 5, 6, 4 }, // Man 0
			{ 5, 4, 6, 7 }, // Man 1
			{ 4, 5, 6, 7 }, // Man 2
			{ 4, 5, 6, 7 }, // Man 3
			{ 0, 1, 2, 3 }, // Woman 4
			{ 0, 1, 2, 3 }, // Woman 5
			{ 0, 1, 2, 3 }, // Woman 6
			{ 0, 1, 2, 3 } // Woman 7
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(prefer);
	}

}
