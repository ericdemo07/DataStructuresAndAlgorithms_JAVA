package heapAndPQ;

import java.util.*;
import java.util.PriorityQueue;
import java.util.TreeMap;

/*
 * GROUND ZERO
 */
public class CreateHeap {

	public static void main(String... args) {
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(2);
		pq.add(8);
		pq.add(3);
		pq.add(1);
		pq.add(1);

		pq.add(5);

		System.out.println(pq.poll());
		System.out.println(pq.peek());
		System.out.println(pq.poll());

		System.out.println(pq.poll());


	}
}