package tree;

public class BinarySearchTreeCommonOperations {

	class Node {
		int data;
		Node left, right;

		public Node(int item) {
			data = item;
			left = right = null;
		}
	}

	private Node insert(int item, Node root) {

		if (root == null) {
			return new Node(item);
		}
		while (root != null) {

			if (item < root.data) {
				if (root.left == null) {
					root.left = new Node(item);
					break;
				}
				root = root.left;
			} else {
				if (root.right == null) {
					root.right = new Node(item);
					break;
				}
				root = root.right;
			}
		}
		return root;
	}

	private void inOrder(Node root) {

		if (root != null) {
			inOrder(root.left);
			System.out.printf("%d ", root.data);
			inOrder(root.right);
		}
	}

	private void reverseInOrder(Node root) {

		if (root != null) {
			reverseInOrder(root.right);
			System.out.printf("%d ", root.data);
			reverseInOrder(root.left);
		}
	}
	
	private void postOrder(Node root) {

		if (root != null) {
			postOrder(root.left);
			postOrder(root.right);
			System.out.printf("%d ", root.data);
		}
	}

	private void preOrder(Node root) {

		if (root != null) {
			System.out.printf("%d ", root.data);
			preOrder(root.left);
			preOrder(root.right);
		}
	}

	public static void main(String[] args) {
		Node root = null;

		BinarySearchTreeCommonOperations bst = new BinarySearchTreeCommonOperations();

		root = bst.insert(20, root);
		bst.insert(10, root);
		bst.insert(30, root);
		bst.insert(2, root);
		bst.insert(11, root);
		bst.insert(15, root);
		bst.insert(9, root);

		bst.inOrder(root);
		System.out.println();
		bst.postOrder(root);
		System.out.println();
		bst.preOrder(root);
		System.out.println();
		bst.reverseInOrder(root);
	}
}
