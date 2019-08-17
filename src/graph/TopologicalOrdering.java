package graph;

import java.util.Iterator;
import java.util.Stack;

public class TopologicalOrdering {

	static int COUNT_OF_NODES = 12;

	public static void main(String... args)  {

		AdjacencyList graph = new AdjacencyList(COUNT_OF_NODES);

		graph.addEdge(7, 11);
		graph.addEdge(7, 8);
		graph.addEdge(5, 11);
		graph.addEdge(11, 2);
		graph.addEdge(11, 9);
		graph.addEdge(11, 10);
		graph.addEdge(3, 8);
		graph.addEdge(8, 9);
		graph.addEdge(3, 10);
		graph.addEdge(2, 7);

		// graph.printAdjacencyListAsMatrix();

		TopologicalOrdering graphNovice = new TopologicalOrdering();
		graphNovice.topologicalSort(graph);
	}

	private void topologicalSort(AdjacencyList graph) {
		boolean[] visited = new boolean[COUNT_OF_NODES];
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < visited.length; i++) {
			Iterator<Integer> iterator = graph.getConnectedNodes(i).listIterator();

			if (!visited[i] && iterator.hasNext()) {
				topologicalSortUtil(graph, visited, i, stack);
			}
		}

		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

	private void topologicalSortUtil(AdjacencyList graph, boolean[] visited, int node, Stack<Integer> stack) {
		visited[node] = true;

		Iterator<Integer> iterator = graph.getConnectedNodes(node).listIterator();

		while (iterator.hasNext()) {
			int next = iterator.next();

			if (!visited[next]) {
				topologicalSortUtil(graph, visited, next, stack);
			}
		}
		
		stack.push(node);
	}

}
