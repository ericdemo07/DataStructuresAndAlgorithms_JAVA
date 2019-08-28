package hashing;

import java.util.*;

public class RelativeSorting {
	public static void main(String[] args) {
		int[] arr1 = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 };
		int[] arr2 = { 2, 1, 8, 3 };

		RelativeSorting dPad = new RelativeSorting();
		dPad.relativeSorting(arr1, arr2);
	}

	private void relativeSorting(int[] arr1, int[] arr2) {
		Map<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

		for (int i = 0; i < arr1.length; i++) {
			map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
		}

		int j = 0;
		for (int i = 0; i < arr2.length; i++) {
			if (map.containsKey(arr2[i])) {
				int count = map.get(arr2[i]);
				int limit = j + count;
				while (j < limit) {
					arr1[j] = arr2[i];
					j++;
				}
				map.remove(arr2[i]);
			}
		}
		Iterator<Map.Entry<Integer, Integer>> entrySet = map.entrySet().iterator();
		int[] temp = new int[arr1.length - j];
		j = 0;
		while (entrySet.hasNext()) {
			Map.Entry<Integer, Integer> entry = entrySet.next();
			int limit = j + entry.getValue();
			while (j < limit) {
				temp[j] = entry.getKey();
				j++;
			}
		}

		Arrays.sort(temp);

		System.arraycopy(temp, 0, arr1, arr1.length - temp.length, temp.length);

		for (int i : arr1) {
			System.out.print(i + "\t");
		}
		System.out.println();
	}
}
