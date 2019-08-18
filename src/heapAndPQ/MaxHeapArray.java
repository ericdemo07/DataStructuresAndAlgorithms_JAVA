package heapAndPQ;

public class MaxHeapArray {

	public int[] arr;
	public int capacity;
	public int countOfElements;

	MaxHeapArray(int capacity) {
		this.capacity = capacity;
		this.countOfElements = 0;
		this.arr = new int[capacity];
	}

	public static void main(String... args) {
		MaxHeapArray heap = new MaxHeapArray(10);
		heap.insert(5);
		heap.insert(7);
		heap.insert(1);
		heap.insert(15);
		heap.insert(12);
		heap.insert(17);
		heap.insert(15);
		heap.poll();
		heap.poll();
		heap.poll();
		heap.reSize();

		System.out.println(heap.getMax());
	}

	private int parent(int i) {
		return (i - 1) / 2;
	}

	private int leftChild(int i) {
		return (2 * i) + 1;
	}

	private int rightChild(int i) {
		return (2 * i) + 2;
	}

	private int getMax() {
		return arr[0];
	}

	private void swap(int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private void heapifyDown(int i) {
		int left = leftChild(i);
		int right = rightChild(i);
		int max = i;

		if (left < capacity && arr[left] > arr[i]) {
			max = left;
		}

		if (right < capacity && arr[right] > arr[max]) {
			max = right;
		}

		if (max != i) {
			swap(i, max);
			heapifyDown(max);
		}
	}

	private void insert(int data) {
		arr[countOfElements] = data;
		heapifyUp(countOfElements);
		countOfElements = countOfElements + 1;
	}

	private void heapifyUp(int i) {
		if (i > 0 && arr[parent(i)] < arr[i]) {
			swap(i, parent(i));
			heapifyUp(parent(i));
		}
	}

	private void reSize() {
		int dummyCapacity = capacity + 10;
		int[] dummyArr = new int[dummyCapacity];
		System.arraycopy(arr, 0, dummyArr, 0, countOfElements);
		capacity = dummyCapacity;
		arr = dummyArr;
	}

	private int poll() {
		int data = arr[0];
		arr[0] = arr[countOfElements - 1];
		heapifyDown(0);
		countOfElements = countOfElements - 1;
		return data;
	}
}