package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfPhoneNumber {

	// String[] mapping = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs",
	// "tuv", "wxyz" };

	static Map<Character, char[]> mapping = new HashMap<Character, char[]>() {
		private static final long serialVersionUID = 1L;
		{
			put('2', new char[] { 'a', 'b', 'c' });
			put('3', new char[] { 'd', 'e', 'f' });
			put('4', new char[] { 'g', 'h', 'i' });
			put('5', new char[] { 'j', 'k', 'l' });
			put('6', new char[] { 'm', 'n', 'o' });
			put('7', new char[] { 'p', 'q', 'r', 's' });
			put('8', new char[] { 't', 'u', 'v' });
			put('9', new char[] { 'w', 'x', 'y', 'z' });
		}
	};

	public static void main(String[] args) {

		List<String> combinations = findCombinations("234");

		for (String a : combinations) {
			System.out.print(a + "\n");
		}
	}

	private static List<String> findCombinations(String keys) {

		List<String> combinations = new ArrayList<String>();

		if (keys == null || keys.length() == 0) {
			return combinations;
		}

		int lengthOfResult = 1;

		for (char a : keys.toCharArray()) {
			lengthOfResult = lengthOfResult * mapping.get(a).length;
		}

		int counter = 0;
		StringBuilder stringBuilder = new StringBuilder();

		System.out.println(lengthOfResult);

		while (counter < lengthOfResult) {

			for (int i = 0; i < keys.length(); i++) {
				stringBuilder.append(mapping.get(keys.charAt(i))[0]);
			}
			combinations.add(stringBuilder.toString());
			stringBuilder = new StringBuilder();
			counter++;
		}

		// String result = "" + mapping.get(keys.charAt(0))[0] +
		// mapping.get(keys.charAt(1))[0]
		// + mapping.get(keys.charAt(2))[0];
		// System.out.println(result);
		//
		// char[] test = new char[keys.length()];
		// char[] as = mapping.get(keys.charAt(0));
		// char[] bs = mapping.get(keys.charAt(1));
		//
		// for (int i = 0; i < as.length; i++) {
		// for (int j = 0; j < bs.length; j++) {
		// combinations.add("" + as[i] + bs[j]);
		// }
		// }

		return combinations;
	}
}
