package array;

import java.util.HashMap;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

	static Map<Integer, char[]> mapping = new HashMap<Integer, char[]>() {
		private static final long serialVersionUID = 1L;
		{
			put(1, new char[] {});
			put(2, new char[] { 'a', 'b', 'c' });
			put(3, new char[] { 'd', 'e', 'f' });
			put(4, new char[] { 'g', 'h', 'i' });
			put(5, new char[] { 'j', 'k', 'l' });
			put(6, new char[] { 'm', 'n', 'o' });
			put(7, new char[] { 'p', 'q', 'r', 's' });
			put(8, new char[] { 't', 'u', 'v' });
			put(9, new char[] { 'w', 'x', 'y', 'z' });
			put(0, new char[] {});
		}
	};

	public static void main(String[] args) {

		String[] combinations = findCombinations(2, 3);

		for (String a : combinations) {
			System.out.print(a + "\t");
		}
	}

	private static String[] findCombinations(int... keys) {

		char[] as = mapping.get(keys[0]);
		char[] bs = mapping.get(keys[1]);

		String[] combinations = new String[as.length * bs.length];

		for (int i = 0; i < as.length; i++) {
			for (int j = 0; j < bs.length; j++) {
				combinations[3 * i + j] = "" + as[i] + bs[j];
			}
		}

		return combinations;
	}
}
