package linkList;

public class CircularLinkedList20 {

	CNode cnode;

	public static void main(String... args) {
		CircularLinkedList20 list = new CircularLinkedList20();

		list.insert(22);
		list.insert(23);
		list.insert(24);
		list.insert(25);
		list.insert(26);
		list.insert(27);

		list.traverse();
	}

	private void traverse() {

		CNode dummyList = cnode;
		while (dummyList.next != cnode) {
			System.out.println(dummyList.data);
			dummyList = dummyList.next;
		}
		System.out.println(dummyList.data);
	}

	private void insert(int data) {
		if (cnode == null) {
			cnode = new CNode(data, null);
			cnode.next = cnode;
			return;
		}
		CNode dummyList = cnode;
		if (dummyList.next == null) {
			dummyList.next = new CNode(data, cnode);
			return;
		}

		while (dummyList.next != cnode) {
			dummyList = dummyList.next;
		}
		dummyList.next = new CNode(data, cnode);
	}
}

class CNode {
	int data;
	CNode next;

	CNode(int data, CNode next) {
		this.data = data;
		this.next = next;
	}
}