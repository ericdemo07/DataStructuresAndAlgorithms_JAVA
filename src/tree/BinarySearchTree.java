package tree;

import java.util.ArrayList;
import java.util.Stack;

public class BinarySearchTree {

	Node root;

	public BinarySearchTree() {
		root = null;
	}

	public static void main(String[] args) {

		BinarySearchTree tree = new BinarySearchTree();

		tree.insert(5);
		tree.insert(2);
		tree.insert(1);
		tree.insert(3);
		tree.insert(13);
		tree.insert(8);
		tree.insert(4);

		tree.preOrderTraverse();

		System.out.println(tree.preOrderTraverseWithoutRecursion().toString());
		System.out.println("max :" + tree.findMaxWithRecursion());
		System.out.println("min :" + tree.findMin());
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

}
