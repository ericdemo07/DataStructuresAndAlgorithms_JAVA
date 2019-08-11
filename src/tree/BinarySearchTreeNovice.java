package tree;

import java.util.ArrayList;
import java.util.Stack;

public class BinarySearchTreeNovice {

	Node root;

	public BinarySearchTreeNovice() {
		root = null;
	}

	public static void main(String[] args) {

		BinarySearchTreeNovice tree = new BinarySearchTreeNovice();

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
		// tree.preOrderTraverse();
		//
		// System.out.println(tree.preOrderTraverseWithoutRecursion().toString());
		// System.out.println("max :" + tree.findMaxWithRecursion());
		// System.out.println("min :" + tree.findMin());

		System.out.println(tree.countElementWithoutRecursion());
		System.out.println("count :" + count1);
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

	private void preOrderTraverse() {
		preOrderTraverseUtil(root);
	}

	private void preOrderTraverseUtil(Node tree) {
		if (tree != null) {
			System.out.println(tree.data);
			preOrderTraverseUtil(tree.left);
			preOrderTraverseUtil(tree.right);
		}
	}

	private ArrayList<Integer> preOrderTraverseWithoutRecursion() {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		if (root == null) {
			return arrayList;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node tempNode = stack.pop();
			arrayList.add(tempNode.data);

			if (tempNode.right != null) {
				stack.push(tempNode.right);
			}
			if (tempNode.left != null) {
				stack.push(tempNode.left);
			}
		}
		return arrayList;
	}

	private int findMax() {
		Node test = root;
		int max = test.data;
		while (test != null) {
			max = test.data;
			test = test.right;
		}
		return max;
	}

	private int findMaxWithRecursion() {
		return findMaxWithRecursionUtil(root);
	}

	private int findMaxWithRecursionUtil(Node tree) {
		int result = tree.data;
		if (tree.right != null) {
			result = Math.max(tree.data, findMaxWithRecursionUtil(tree.right));
		}
		return result;
	}

	private int findMin() {
		Node test = root;
		int min = test.data;
		while (test != null) {
			min = test.data;
			test = test.left;
		}
		return min;
	}

	private boolean elementExist(int element) {

		return elementExistUtil(root, element);
	}

	private static int count1 = 0;

	private boolean elementExistUtil(Node tree, int element) {
		if (tree == null) {
			return false;
		}
		if (element == tree.data) {
			return true;
		}
		if (element < tree.data) {
			return elementExistUtil(tree.left, element);
		}
		return elementExistUtil(tree.right, element);
	}

	private int countElements() {
		return countElementsUtil(root, 0);
	}

	private int countElementsUtil(Node tree, int count) {
		count1++;

		if (tree == null) {
			return count;
		}

		int left = count + (tree.left != null ? countElementsUtil(tree.left, count) : 0);
		int right = count + (tree.right != null ? countElementsUtil(tree.right, count) : 0);

		return left + right + 1;
	}

	private int countElementWithoutRecursion() {
		int count = 0;
		if (root == null) {
			return count;
		}
		Stack<Node> stack = new Stack<Node>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node tempNode = stack.pop();
			count++;

			if (tempNode.right != null) {
				stack.push(tempNode.right);
			}
			if (tempNode.left != null) {
				stack.push(tempNode.left);
			}
		}
		return count;
	}
}
