package heapAndPQ;

import java.util.PriorityQueue;

public class KthLargestInStream {

	PriorityQueue<Integer> pq;
	int K;

	KthLargestInStream() {
		this.pq = new PriorityQueue<Integer>();
		this.K = 3;

		for (int i = 0; i < K; i++) {
			pq.add(i);
		}
	}

	public static void main(String... args) {
		KthLargestInStream kth = new KthLargestInStream();

		kth.add(1);
		kth.add(2);
		kth.add(3);
		kth.add(4);
		kth.add(5);
		kth.add(59);
		kth.add(5);
		kth.add(50);
		kth.add(50);
		kth.add(45);
		kth.add(5);

		System.out.println(kth.getKthLargest());
	}

	private void add(int element) {
		if (element > pq.peek()) {
			pq.poll();
			pq.add(element);
		}
	}

	private int getKthLargest() {
		return pq.peek();
	}
}
