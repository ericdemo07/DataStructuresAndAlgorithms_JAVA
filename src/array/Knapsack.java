package array;

import java.util.Arrays;
import java.util.Comparator;

public class Knapsack {

	public static void main(String[] args) {
		int BAG_SIZE = 15;
		int COUNT_OF_ITEMS = 7;

		Item items[] = new Item[COUNT_OF_ITEMS];

		items[0] = new Item(0, 10, 2, 10 / 2F);
		items[1] = new Item(1, 5, 3, 5 / 3F);
		items[2] = new Item(2, 15, 5, 15 / 5F);
		items[3] = new Item(3, 7, 7, 7 / 7F);
		items[4] = new Item(4, 6, 1, 6 / 1F);
		items[5] = new Item(5, 18, 4, 18 / 4F);
		items[6] = new Item(6, 3, 1, 3 / 1F);

		Arrays.sort(items, Comparator.comparing(Item::getAvgProfit).reversed());

		float[] bag = findOptimum(items, BAG_SIZE);

		// this is how a full bag will loom like
		for (float i : bag) {
			System.out.println(i);
		}

	}

	private static float[] findOptimum(Item items[], int max) {
		float[] out = new float[items.length];
		int availableSpace = max;
		int i = 0;
		while (availableSpace > 0) {
			int quantity = items[i].quantity;
			if (quantity < availableSpace) {
				out[i] = quantity;
				availableSpace = availableSpace - quantity;
			} else {
				out[i] = availableSpace;
				availableSpace = 0;
			}
			i++;
		}
		return out;
	}
}

class Item {
	int id;
	int profit;
	int quantity;
	float avgProfit;

	Item(int id, int profit, int quantity, float avgProfit) {
		this.id = id;
		this.profit = profit;
		this.quantity = quantity;
		this.avgProfit = avgProfit;
	}

	public float getAvgProfit() {
		return this.avgProfit;
	}
}