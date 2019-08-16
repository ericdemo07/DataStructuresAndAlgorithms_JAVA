package linkList;

public class DoublyLinkedList20 {

	DNode dNode;

	public static void main(String... args) {
		DoublyLinkedList20 list = new DoublyLinkedList20();

		list.insert(10);
		list.insert(20);
		list.insert(30);

		list.traverse();
	}

	private void traverse() {
		DNode dummyList = dNode;

		while (dummyList.next != null) {
			System.out.println(dummyList.data);
			dummyList = dummyList.next;
		}
		System.out.println(dummyList.data + "\n\n");
		while (dummyList.prev != null) {
			System.out.println(dummyList.data);
			dummyList = dummyList.prev;
		}
		System.out.println(dummyList.data);
	}

	private void insert(int data) {
		if (dNode == null) {
			dNode = new DNode(data, null);
			return;
		}

		DNode dummyList = dNode;
		while (dummyList.next != null) {
			dummyList = dummyList.next;
		}
		dummyList.next = new DNode(data, dummyList);
	}
}

class DNode {
	int data;
	DNode prev;
	DNode next;

	DNode(int data, DNode prev) {
		this.data = data;
		this.prev = prev;
		next = null;
	}
}