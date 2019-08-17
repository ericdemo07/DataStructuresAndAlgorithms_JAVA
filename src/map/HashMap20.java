package map;

public class HashMap20 {
	Node[] map;
	int capacity;
	int countOfElements;

	HashMap20(int capacity) {
		map = new Node[capacity];
		this.capacity = capacity;
		this.countOfElements = 0;
	}

	public static void main(String... args) {
		HashMap20 hashMap = new HashMap20(16);

		hashMap.put(1, 1);
		hashMap.put(2, 2);
		hashMap.put(3, 2);

		for (int i = 3; i < 19; i++) {
			hashMap.put(i, i);
		}

		// System.out.println(hashMap.get(3));
		hashMap.traverse();
	}

	private void traverse() {
		for (Node i : map) {
			System.out.println(i);
		}
	}

	private void put(int key, int value) {
		Node node = new Node(key, value);
		int i = getHash(key);
		if (map[i] == null) {
			map[i] = node;
		} else {
			Node dummyNode = map[i];
			while (dummyNode.next != null) {
				dummyNode = dummyNode.next;
			}
			dummyNode.next = node;
		}
		countOfElements = countOfElements + 1;

		int loadFactor = countOfElements / capacity;

		if (loadFactor > 0.75) {
			reSize();
		}
	}

	private int get(int key) {
		int i = getHash(key);

		if (map[i] != null) {
			Node dummyNode = map[i];
			while (dummyNode != null) {
				if (dummyNode.key == key) {
					return dummyNode.value;
				} else {
					dummyNode = dummyNode.next;
				}
			}
		}
		return 0;
	}

	private int getHash(int i) {
		return i % capacity;
	}

	private void reSize() {
		int dummyCapacity = capacity + 16;
		Node[] dummyMap = new Node[dummyCapacity];
		System.arraycopy(map, 0, dummyMap, 0, countOfElements);
		capacity = dummyCapacity;
		map = dummyMap;
	}
}

class Node {
	int key;
	int value;
	int hash;
	Node next;

	Node(int key, int value) {
		this.key = key;
		this.value = value;
		this.hash = key;
		this.next = null;
	}
}
