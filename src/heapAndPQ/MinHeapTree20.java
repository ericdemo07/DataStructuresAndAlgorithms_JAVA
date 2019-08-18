package heapAndPQ;

public class MinHeapTree20 {

	Node minHeap;

	public static void main(String... args) {
		MinHeapTree20 tree = new MinHeapTree20();

		tree.insert(7);
		tree.insert(5);
		tree.insert(4);
		tree.insert(2);
		// tree.traverse();
		tree.insert(1);
		// tree.traverse();
		// tree.insert(2);
		tree.insert(8);
		tree.insert(9);
		tree.traverse();
		// tree.traverse();
	}

	private void getData() {
		System.out.println("data\n\n :" + minHeap.right.right);
	}

	private void traverse() {
		System.out.println("\n\ntraversing...");
		traverseUtil(minHeap);
	}

	private void traverseUtil(Node tree) {

		if (tree != null) {
			System.out.println(tree.data);
			traverseUtil(tree.left);
			traverseUtil(tree.right);
		}
	}

	private void insert(int data) {
		minHeap = insertUtil(data, minHeap);
	}

	private Node insertUtil(int data, Node tree) {
		if (tree == null) {
			tree = new Node(data);
			return tree;
		}
		if (data < tree.data) {
			Node dummyNode = new Node(data);
			dummyNode.right = tree.right;
			dummyNode.left = tree;
			return dummyNode;
		}
		if (tree.left == null) {
			tree.left = insertUtil(data, tree.left);
		}
		tree.right = insertUtil(data, tree.right);

		return tree;
	}
}

class Node {
	int data;
	Node left;
	Node right;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}
