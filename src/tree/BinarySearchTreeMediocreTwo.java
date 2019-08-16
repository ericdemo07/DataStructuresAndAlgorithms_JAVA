package tree;

public class BinarySearchTreeMediocreTwo {

	Node root;

	public BinarySearchTreeMediocreTwo() {
		root = null;
	}

	public static void main(String[] args) {
		BinarySearchTreeMediocreTwo tree = new BinarySearchTreeMediocreTwo();

		tree.insert(5);
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		tree.insert(13);
		tree.insert(8);
		tree.insert(4);
		tree.insert(7);
		tree.insert(19);
		tree.insert(6);
		tree.insert(11);

		System.out.println(tree.shortestPath(1, 3));
	}

	private void insert(int data) {
		root = insertUtil(root, data);
	}

	private Node insertUtil(Node tree, int data) {
		if (tree == null) {
			tree = new Node(data);
			return tree;
		}

		if (data > tree.data) {
			tree.right = insertUtil(tree.right, data);
		} else if (data < tree.data) {
			tree.left = insertUtil(tree.left, data);
		}
		return tree;
	}

	private int longestCommonSubsequence(int start, int end) {
		return longestCommonSubsequenceUtil(root, start, end);
	}

	static int count1 = 0;

	private int longestCommonSubsequenceUtil(Node tree, int start, int end) {
		if (tree == null) {
			return 0;
		}
		if (tree.data == start || tree.data == end) {
			return tree.data;
		}

		int left = tree.left != null ? longestCommonSubsequenceUtil(tree.left, start, end) : 0;
		int right = tree.right != null ? longestCommonSubsequenceUtil(tree.right, start, end) : 0;

		if (left != 0 && right != 0) {
			return tree.data;
		}

		if (left == 0 && right == 0) {
			return 0;
		}
		return left != 0 ? left : right;
	}

	private int shortestPath(int start, int end) {
		return shortestPathUtil(root, start, end, 0);
	}

	private int shortestPathUtil(Node tree, int start, int end, int distance) {
		if (tree == null) {

			return distance + 1;
		}

		if (tree.data == start || tree.data == end) {
			System.out.println("hello");
			distance = distance + 1;
		}

		int left = shortestPathUtil(tree.left, start, end, distance);
		int right = shortestPathUtil(tree.right, start, end, distance);

		System.out.println("left :" + left + "    |    right :" + right);
		return left + right;
	}
}
