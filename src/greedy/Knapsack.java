package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Knapsack {

	public static void main(String... args) {
		int bagSize = 15;
		int[] profits = { 10, 5, 15, 7, 6, 18, 3 };
		int[] weights = { 2, 3, 5, 7, 1, 4, 1 };
		List<Item> items = new ArrayList<Item>();

		for (int i = 0; i < profits.length; i++) {
			items.add(new Item(profits[i], weights[i]));
		}

		Collections.sort(items, (Item i1, Item i2) -> Float.compare(i2.avg, i1.avg));

		Knapsack knapsack = new Knapsack();
		System.out.println(knapsack.packBag(items, bagSize));
	}

	private List<Float> packBag(List<Item> items, int bagSize) {
		List<Float> bag = new ArrayList<Float>();
		int i = 0;

		while (bagSize > 0) {
			int weight = items.get(i).weight;
			if (bagSize >= weight) {
				bag.add((float) weight);
				bagSize = bagSize - weight;
			} else {
				float value = (float) bagSize / weight;
				bag.add(value);
				bagSize = 0;
			}
			i++;
		}
		return bag;
	}

	static class Item {
		int profit;
		int weight;
		float avg;

		Item(int profit, int weight) {
			this.profit = profit;
			this.weight = weight;
			this.avg = (float) profit / weight;
		}
	}
}
