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
		pq.add(5);
		Math.abs(1);
		int[] a = { 1, 2, 3 };
		int[] b = new int[6];
		int a1 = 2232131;
		System.out.println("hashcode : " + Integer.hashCode(a1));

		String test = "pneumonia";
test.toCharArray();
		System.arraycopy(a, 0, b, 0, a.length);
		Map<Character, Integer> map = new TreeMap<Character, Integer>();
		map.put('a', 1);
		map.put('a', 1);
		
		for(Map.Entry<Character, Integer> m : map.entrySet()){
		}
		

		
		System.out.println("map : "+map.get('a'));
		for (int i : b) {
			System.out.println(i);
		}
		System.out.println(pq.poll());
		System.out.println(pq.poll());
		Node aaa2 = new Node();
		Node aaa1 = new Node();

		System.out.println(aaa2.getHash());
		System.out.println(aaa1.v);

	}
}

class Node {
	int k;
	int v;

	Node() {
		this.k = 122121;
		this.v = hashCode();
	}
	
	int getHash() {
		return this.v;
	}
}