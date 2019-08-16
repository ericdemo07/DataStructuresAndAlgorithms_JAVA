package linkList;

public class LinkedListNovice {
	Node linkList;

	public static void main(String... args) {

		LinkedListNovice linkedList1 = new LinkedListNovice();
		LinkedListNovice linkedList2 = new LinkedListNovice();
		LinkedListNovice linkedList3 = new LinkedListNovice();

		linkedList1.insert(12);
		linkedList1.insert(22);
		linkedList1.insert(32);
		linkedList1.insert(32);
		linkedList1.insert(22);
		linkedList1.insert(12);

		linkedList2.insert(13);
		linkedList2.insert(23);
		linkedList2.insert(33);
		linkedList2.insert(123);
		linkedList2.insert(133);

		linkedList2.traverse();
		linkedList2.reverse();
		// linkedList1.peekNthFromEnd(4);
		linkedList2.traverse();

		// System.out.println(linkedList1.isPalindrome());

		// Node mergeList = linkedList1.mergeSorted(linkedList2.getList());
		// linkedList3.traverse(mergeList);
	}

	private Node getList() {
		return linkList;
	}

	private void reverse() {
		if (linkList == null) {
			return;
		}
		Node prev = null;
		Node next = null;
		Node dummyList = linkList;
		while (dummyList != null) {
			next = dummyList.next;
			dummyList.next = prev;
			prev = dummyList;
			dummyList = next;
		}
		linkList = prev;
	}

	private void traverse() {
		if (linkList == null) {
			return;
		}
		Node linkListDummy = linkList;
		while (linkListDummy != null) {
			System.out.println(linkListDummy.data);
			linkListDummy = linkListDummy.next;
		}
	}

	private boolean isPalindrome() {
		if (linkList == null) {
			return false;
		}

		Node tortoise = linkList;
		Node hare = linkList;

		StackUsingLinkedList20 stack = new StackUsingLinkedList20();

		while (hare != null && hare.next != null) {
			stack.push(tortoise.data);
			tortoise = tortoise.next;
			hare = hare.next.next;
		}

		if (hare != null) {
			tortoise = tortoise.next;
		}

		while (tortoise != null) {
			if (stack.popInt() != tortoise.data) {
				return false;
			}
			tortoise = tortoise.next;
		}
		return true;
	}

	private Node mergeSorted(Node linkList1) {

		Node linkListDummy = linkList;
		Node linkListMerge2 = null;

		if (linkListDummy != null && linkList1 != null) {
			if (linkListDummy.data < linkList1.data) {
				linkListMerge2 = new Node(linkListDummy.data);
				linkListDummy = linkListDummy.next;
			} else {
				linkListMerge2 = new Node(linkList1.data);
				linkList1 = linkList1.next;
			}
		}
		Node linkListMerge = linkListMerge2;

		while (linkListDummy != null && linkList1 != null) {
			if (linkListDummy.data < linkList1.data) {
				linkListMerge.next = new Node(linkListDummy.data);
				linkListDummy = linkListDummy.next;
			} else {
				linkListMerge.next = new Node(linkList1.data);
				linkList1 = linkList1.next;
			}
			linkListMerge = linkListMerge.next;
		}

		while (linkListDummy != null) {
			linkListMerge.next = new Node(linkListDummy.data);
			linkListDummy = linkListDummy.next;
			linkListMerge = linkListMerge.next;
		}

		while (linkList1 != null) {
			linkListMerge.next = new Node(linkList1.data);
			linkList1 = linkList1.next;
			linkListMerge = linkListMerge.next;
		}

		return linkListMerge2;
	}

	private void traverse(Node list) {
		if (list == null) {
			return;
		}

		while (list != null) {
			System.out.println(list.data);
			list = list.next;
		}
	}

	private void reversePrint() {
		reversePrintUtil(linkList);
	}

	private void reversePrintUtil(Node node) {
		if (node != null) {
			reversePrintUtil(node.next);
			System.out.println(node.data);
		}
	}

	private void delete(int n) {
		if (linkList == null) {
			return;
		}

		Node linkListDummy = linkList;
		Node prev = null;
		while (linkListDummy.next != null) {
			prev = linkListDummy;
			linkListDummy = linkListDummy.next;
		}
		prev.next = prev.next.next;
	}

	private void peekNthFromEnd(int n) {
		if (linkList == null) {
			return;
		}
		int i = 1;
		Node linkListDummy = linkList;
		Node nThNode = linkList;
		while (linkListDummy.next != null) {
			if (i >= n) {
				nThNode = nThNode.next;
			}
			linkListDummy = linkListDummy.next;
			i++;
		}
		System.out.println("NthFromEnd :" + nThNode.data);
	}

	private void insert(int data) {
		Node node = new Node(data);

		if (linkList == null) {
			linkList = node;
			return;
		}

		Node linkListDummy = linkList;
		while (linkListDummy.next != null) {
			linkListDummy = linkListDummy.next;
		}

		linkListDummy.next = node;
	}
}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}
