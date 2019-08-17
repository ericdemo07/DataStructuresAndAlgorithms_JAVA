package graph;

import java.util.ArrayList;
import java.util.Iterator;

public class CountOfTopologicalSort {
	static int COUNT_OF_NODES = 8;
	static int COUNT_OF_TOPOLOGICAL_SORT = 0;

	public static void main(String... args) {

		AdjacencyList graph = new AdjacencyList(COUNT_OF_NODES);
		// brought elements equivalent to index
		graph.addEdge(3, 7);
		graph.addEdge(3, 4);
		graph.addEdge(2, 7);
		graph.addEdge(7, 0);
		graph.addEdge(7, 5);
		graph.addEdge(7, 6);
		graph.addEdge(1, 4);
		graph.addEdge(4, 5);
		graph.addEdge(1, 6);

		// graph.printAdjacencyListAsMatrix();

		CountOfTopologicalSort graphNovice2 = new CountOfTopologicalSort();
		graphNovice2.topologicalSort(graph);
	}

	private void topologicalSort(AdjacencyList graph) {
		boolean[] visited = new boolean[COUNT_OF_NODES];
		ArrayList<Integer> arrList = new ArrayList<>();
		int[] indegree = new int[COUNT_OF_NODES];

		for (int i = 0; i < COUNT_OF_NODES; i++) {
			Iterator<Integer> iterator = graph.getConnectedNodes(i).listIterator();

			while (iterator.hasNext()) {
				int next = iterator.next();
				indegree[next] = indegree[next] + 1;
			}
		}
		topologicalSortUtil(graph, visited, arrList, indegree);
		System.out.println("\nCOUNT_OF_TOPOLOGICAL_SORT : " + COUNT_OF_TOPOLOGICAL_SORT);
	}

	private void topologicalSortUtil(AdjacencyList graph, boolean[] visited, ArrayList<Integer> arrList,
			int[] indegree) {

		boolean flag = false;

		for (int node = 0; node < visited.length; node++) {
			if (indegree[node] == 0 && !visited[node]) {

				visited[node] = true;
				arrList.add(node);

				Iterator<Integer> iterator = graph.getConnectedNodes(node).listIterator();

				while (iterator.hasNext()) {
					int next = iterator.next();
					indegree[next] = indegree[next] - 1;
				}
				topologicalSortUtil(graph, visited, arrList, indegree);

				visited[node] = false;
				arrList.remove(arrList.size() - 1);

				Iterator<Integer> iterator1 = graph.getConnectedNodes(node).listIterator();

				while (iterator1.hasNext()) {
					int next = iterator1.next();
					indegree[next] = indegree[next] + 1;
				}
				flag = true;
			}
		}

		if (!flag) {
			COUNT_OF_TOPOLOGICAL_SORT = COUNT_OF_TOPOLOGICAL_SORT + 1;
			System.out.println(arrList);
		}
	}
}
