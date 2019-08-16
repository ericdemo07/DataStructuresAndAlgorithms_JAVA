package linkList;

public class StackUsingLinkedList20 {

	SNode stack;

	public static void main(String... args) {

		StackUsingLinkedList20 stackAsList = new StackUsingLinkedList20();

		stackAsList.push(20);
		stackAsList.push(30);
		stackAsList.push(40);
		stackAsList.push(50);
		stackAsList.push(60);

		stackAsList.peek();

		stackAsList.pop();
		stackAsList.pop();

		stackAsList.peek();

		stackAsList.traverse();
	}

	private void traverse() {
		SNode dummyStack = stack;

		while (dummyStack != null) {
			System.out.println(dummyStack.data);
			dummyStack = dummyStack.next;
		}
	}

	private void peek() {
		System.out.println("peek :" + stack.data);
	}

	public void push(int data) {
		if (stack == null) {
			stack = new SNode(data);
			return;
		}

		SNode node = new SNode(data);
		node.next = stack;
		stack = node;
	}

	private void pop() {
		SNode dummyStack = stack.next;
		stack.next = null;
		System.out.println("popped out :" + stack.data);
		stack = dummyStack;
	}

	public int popInt() {
		SNode dummyStack = stack.next;
		stack.next = null;
		int test = stack.data;
		stack = dummyStack;
		return test;
	}
}

class SNode {
	int data;
	SNode next;

	SNode(int data) {
		this.data = data;
		this.next = null;
	}
}