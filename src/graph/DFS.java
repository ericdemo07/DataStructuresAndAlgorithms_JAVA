package graph;

import java.util.Iterator;

public class DFS {

	private static int countOfNodes;
	static AdjacencyList graph;

	DFS() {
		countOfNodes = 9;
	}

	public static void main(String[] args) {
		new DFS();
		
		graph = new AdjacencyList(countOfNodes);

		graph.addEdge(1, 2);
		graph.addEdge(1, 3);

		graph.addEdge(2, 4);
		graph.addEdge(2, 5);

		graph.addEdge(3, 5);
		graph.addEdge(3, 8);
		graph.addEdge(3, 7);

		search(1);

	}

	private static void search(int start) {

		boolean explored[] = new boolean[countOfNodes];

		searchUtil(start, explored);
	}

	private static void searchUtil(int start, boolean[] explored) {

		explored[start] = true;
		System.out.println(start + " ");

		Iterator<Integer> iterator = graph.getConnectedNodes(start).listIterator();

		while (iterator.hasNext()) {
			int n = iterator.next();

			if (!explored[n]) {
				searchUtil(n, explored);
			}
		}
	}

}
