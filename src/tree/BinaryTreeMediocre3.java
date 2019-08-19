package tree;

//includes node deletion
public class BinaryTreeMediocre3 {

	Node node;

	public static void main(String... args) {
		BinaryTreeMediocre3 bTree = new BinaryTreeMediocre3();
		bTree.insert(5);
		bTree.insert(3);
		bTree.insert(4);
		bTree.insert(2);
		bTree.insert(7);
		bTree.insert(9);
		bTree.insert(8);
		bTree.insert(11);
		bTree.insert(10);

		bTree.traverse();
		bTree.delete(3);
		System.out.println("\n");
		bTree.traverse();
	}

	private Node findMin(Node tree) {
		if (tree == null) {
			return new Node(Integer.MAX_VALUE);
		}

		Node res = tree;
		Node lRes = findMin(tree.left);
		Node rRes = findMin(tree.right);

		if (lRes.data < res.data) {
			res = lRes;
		}
		if (rRes.data < res.data) {
			res = lRes;
		}
		return res;
	}

	private void delete(int data) {
		deleteUtil(node, data);
	}

	private Node deleteUtil(Node tree, int data) {
		if (tree == null) {
			return tree;
		}

		if (data > tree.data) {
			tree.right = deleteUtil(tree.right, data);
		} else if (data < tree.data) {
			tree.left = deleteUtil(tree.left, data);
		} else {
			if (tree.right == null && tree.left == null) {
				tree = null;
			} else if (tree.left == null) {
				tree = tree.right;
				return tree;
			} else if (tree.right == null) {
				tree = tree.left;
				return tree;
			} else {
				Node min = findMin(tree.right);
				tree.data = min.data;
				tree.right = deleteUtil(tree.right, min.data);
			}
		}
		return tree;
	}

	private void traverse() {
		traverseUtil(node);
	}

	private void traverseUtil(Node tree) {
		if (tree == null) {
			return;
		}
		traverseUtil(tree.left);
		System.out.println(tree.data);
		traverseUtil(tree.right);
	}

	private void insert(int data) {
		node = insertUtil(node, data);
	}

	private Node insertUtil(Node tree, int data) {
		if (tree == null) {
			tree = new Node(data);
			return tree;
		}

		if (data > tree.data) {
			tree.right = insertUtil(tree.right, data);
		} else {
			tree.left = insertUtil(tree.left, data);
		}
		return tree;
	}

	class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}
}