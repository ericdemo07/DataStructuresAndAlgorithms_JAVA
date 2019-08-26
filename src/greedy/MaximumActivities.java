package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import array.DummyPad;

public class MaximumActivities {
	public static void main(String[] args) {
		int[] start = { 1, 3, 0, 5, 8, 5 };
		int[] end = { 2, 4, 6, 7, 9, 9 };
		List<Item1> items = new ArrayList<Item1>();

		for (int i = 0; i < start.length; i++) {
			items.add(new Item1(start[i], end[i]));
		}

		Collections.sort(items, (Item1 i1, Item1 i2) -> i1.end - i2.end);

		for (int i = 0; i < start.length; i++) {
			start[i] = items.get(i).start;
			end[i] = items.get(i).end;
		}

		MaximumActivities dummyPad = new MaximumActivities();
		dummyPad.countActivities(start, end);
	}

	private void countActivities(int[] start, int[] end) {
		int startPtr = 1;
		int endPtr = 0;
		int count = 1;

		while (endPtr < start.length - 1 && startPtr < start.length) {
			if (start[startPtr] >= end[endPtr]) {
				count++;
				endPtr = startPtr;
				startPtr++;
			} else {
				startPtr++;
			}
		}
		System.out.println(count);
	}

}

class Item1 {
	int start;
	int end;

	Item1(int start, int end) {
		this.start = start;
		this.end = end;
	}
}
