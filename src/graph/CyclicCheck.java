package graph;

import java.util.Iterator;
import java.util.Stack;

public class CyclicCheck {
	static int COUNT_OF_NODES = 12;

	public static void main(String... args) {

		AdjacencyList graph = new AdjacencyList(COUNT_OF_NODES);

		graph.addEdge(1, 0);
		// graph.addEdge(7, 8);
		// graph.addEdge(5, 11);
		graph.addEdge(0, 2);
		// graph.addEdge(11, 9);
		// graph.addEdge(11, 10);
		// graph.addEdge(3, 8);
		// graph.addEdge(8, 9);
		// graph.addEdge(3, 10);
		graph.addEdge(2, 3);

		CyclicCheck graphNovice = new CyclicCheck();
		System.out.println(graphNovice.isCyclicUndirected(graph));
	}

	private boolean isCyclicUndirected(AdjacencyList graph) {
		boolean[] visited = new boolean[COUNT_OF_NODES];

		for (int i = 0; i < visited.length; i++) {
			Iterator<Integer> iterator = graph.getConnectedNodes(i).listIterator();

			if (!visited[i] && iterator.hasNext()) {
				if (isCyclicUndirectedUtil(graph, visited, i, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isCyclicUndirectedUtil(AdjacencyList graph, boolean[] visited, int node, int parent) {
		visited[node] = true;
		Iterator<Integer> iterator = graph.getConnectedNodes(node).listIterator();

		while (iterator.hasNext()) {
			int n = iterator.next();

			if (!visited[n]) {
				if (isCyclicUndirectedUtil(graph, visited, n, node)) {
					return true;
				}
			} else if (n != parent) {
				System.out.println("hello :" + n + "  |  parent :" + parent);
				return true;
			}
		}
		return false;
	}

	private boolean isCyclicDirected(AdjacencyList graph) {
		boolean[] visited = new boolean[COUNT_OF_NODES];
		boolean[] stack = new boolean[COUNT_OF_NODES];

		for (int i = 0; i < visited.length; i++) {
			Iterator<Integer> iterator = graph.getConnectedNodes(i).listIterator();

			if (!visited[i] && iterator.hasNext()) {
				if (isCylicDirectedUtil(graph, visited, i, stack)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean isCylicDirectedUtil(AdjacencyList graph, boolean[] visited, int node, boolean[] stack) {
		if (stack[node]) {
			return true;
		}
		if (visited[node]) {
			return false;
		}
		visited[node] = true;
		stack[node] = true;

		Iterator<Integer> iterator = graph.getConnectedNodes(node).listIterator();

		while (iterator.hasNext()) {
			int next = iterator.next();

			if (isCylicDirectedUtil(graph, visited, next, stack)) {
				return true;
			}

		}
		stack[node] = false;

		return false;

	}
}
