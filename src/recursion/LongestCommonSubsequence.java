package recursion;

//https://www.youtube.com/watch?v=sSno9rV8Rhg
public class LongestCommonSubsequence {

	static int count = 0;

	public static void main(String[] args) {
		char[] temp1 = { 'a', 'e', 'i', 'o', 'u' };
		//prefixing `a` in temp2 brings down iteration 
		char[] temp2 = { 'e', 'o', 'u' };

		System.out.println(LCS(0, temp1, 0, temp2) + "  count: " + count);

	}

	private static int LCS(int i, char[] temp1, int j, char[] temp2) {
		count++;
		if (i == temp1.length || j == temp2.length) {
			return 0;
		} else if (temp1[i] == temp2[j]) {
			return 1 + LCS(i + 1, temp1, j + 1, temp2);
		}
		return Math.max(LCS(i + 1, temp1, j, temp2), LCS(i, temp1, j + 1, temp2));
	}
}
