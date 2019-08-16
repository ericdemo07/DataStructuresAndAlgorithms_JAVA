package tree;

public class BinarySearchTreeMediocre {

	Node root;

	public BinarySearchTreeMediocre() {
		root = null;
	}

	public static void main(String[] args) {

		BinarySearchTreeMediocre tree = new BinarySearchTreeMediocre();
		BinarySearchTreeMediocre tree2 = new BinarySearchTreeMediocre();

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

		tree2.insert(5);
		tree2.insert(2);
		tree2.insert(1);
		tree2.insert(3);
		tree2.insert(13);
		tree2.insert(8);
		tree2.insert(4);
		tree2.insert(7);
		tree2.insert(19);
		tree2.insert(6);
		tree2.insert(11);

		tree2.convertToMirror();
		System.out.println("isMirror :" + tree.mirrorCheck(tree2.getRootNode()));

	}

	private Node getRootNode() {
		return root;
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

	private int getHeight() {

		return getHeightUtil(root);
	}

	private int getHeightUtil(Node tree) {
		if (tree == null) {
			return 0;
		}
		int lheight = 1 + (tree.left == null ? 0 : getHeightUtil(tree.left));
		int rHeight = 1 + (tree.right == null ? 0 : getHeightUtil(tree.right));

		return Math.max(lheight, rHeight);
	}

	private void levelOrderTraversal() {
		int height = getHeight();
		for (int i = 1; i <= height; i++) {
			printLevel(root, i);
			int sum = levelSum(root, i, 0);
			System.out.println("sum :" + sum);
		}
	}

	private void printLevel(Node tree, int level) {
		if (tree == null) {
			return;
		}
		if (level == 1) {
			System.out.println(tree.data);
		} else if (level > 1) {
			printLevel(tree.left, level - 1);
			printLevel(tree.right, level - 1);
		}
	}

	private int levelSum(Node tree, int level, int sum) {
		if (tree == null) {
			return sum;
		}
		if (level == 1) {
			return sum + tree.data;
		}
		return levelSum(tree.left, level - 1, sum) + levelSum(tree.right, level - 1, sum);
	}

	private int countLeaves() {
		return countLeavesUtil(root, 0);
	}

	private int countLeavesUtil(Node tree, int count) {
		if (tree.left == null || tree.right == null) {
			return count + 1;
		}

		int lSum = countLeavesUtil(tree.left, count);
		int rSum = countLeavesUtil(tree.right, count);

		return lSum + rSum;
	}

	private int minDepth() {
		return minDepthUtil(root);
	}

	private int minDepthUtil(Node tree) {
		if (tree == null) {
			return 0;
		}

		int lDepth = 1 + (tree.left == null ? 0 : minDepthUtil(tree.left));
		int rDepth = 1 + (tree.right == null ? 0 : minDepthUtil(tree.right));

		return Math.min(lDepth, rDepth);
	}

	private int countOfFullNode() {
		return countOfFullNodeUtil(root);
	}

	private int countOfFullNodeUtil(Node tree) {
		if (tree == null) {
			return 0;
		}

		int res = 0;
		if (tree.left != null && tree.right != null) {
			res = res + 1;
		}

		int lSum = countOfFullNodeUtil(tree.left);
		int rSum = countOfFullNodeUtil(tree.right);

		return res + lSum + rSum;
	}

	private boolean compareTwoTrees(Node tree2) {
		return compareTwoTreesUtil(root, tree2);

	}

	private boolean compareTwoTreesUtil(Node tree1, Node tree2) {
		if (tree1 == null && tree2 == null) {
			return true;
		}

		if (tree1 != null && tree2 != null) {

			return tree1.data == tree2.data && compareTwoTreesUtil(tree1.left, tree2.left)
					&& compareTwoTreesUtil(tree1.right, tree2.right);
		}
		return false;
	}

	private boolean pathExistWithGivenSum(int sum) {
		return pathExistWithGivenSumUtil(root, sum);
	}

	private boolean pathExistWithGivenSumUtil(Node tree, int sum) {
		if (tree == null) {
			return false;
		}
		if (tree.left == null && tree.right == null && tree.data == sum) {
			return true;
		}
		return pathExistWithGivenSumUtil(tree.left, sum - tree.data)
				|| pathExistWithGivenSumUtil(tree.right, sum - tree.data);
	}

	private void convertToMirror() {
		convertToMirrorUtil(root);
	}

	private void convertToMirrorUtil(Node node) {
		Node temp;
		if (node != null) {
			convertToMirrorUtil(node.left);
			convertToMirrorUtil(node.right);

			temp = node.left;
			node.left = node.right;
			node.right = temp;
		}
	}

	private boolean mirrorCheck(Node tree2) {
		return mirrorCheckUtil(root, tree2);
	}

	private boolean mirrorCheckUtil(Node tree1, Node tree2) {
		if (tree1 == null && tree2 == null) {
			return true;
		}
		if (tree1 == null || tree2 == null) {
			return false;
		}
		if (tree1.data != tree2.data) {
			return false;
		}

		return mirrorCheckUtil(tree1.left, tree2.right) && mirrorCheckUtil(tree1.right, tree2.left);
	}
}
