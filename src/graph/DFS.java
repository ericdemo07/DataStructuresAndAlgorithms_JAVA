package graph;

import java.util.Iterator;

public class DFS {

	public static void main(String... args) {

		int countOfNodes = 9;

		AdjacencyList graph = new AdjacencyList(countOfNodes);

		graph.addEdge(1, 2);
		graph.addEdge(1, 3);

		graph.addEdge(2, 4);
		graph.addEdge(2, 5);

		graph.addEdge(3, 5);
		graph.addEdge(3, 7);
		graph.addEdge(3, 8);

		DFS dfs = new DFS();

		dfs.traverse(graph, new boolean[countOfNodes], 1);
	}

	void traverse(AdjacencyList graph, boolean[] explored, int node) {

		explored[node] = true;
		System.out.print(node + " ");

		Iterator<Integer> iterator = graph.getConnectedNodes(node).listIterator();

		while (iterator.hasNext()) {
			int n = iterator.next();

			if (!explored[n]) {
				traverse(graph, explored, n);
				System.out.println();
			}
		}

	}

}
