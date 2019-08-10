package tree;

public class Node {

	int data;
	Node left;
	Node right;

	Node node = null;

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}
