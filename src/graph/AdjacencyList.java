package graph;

import java.util.LinkedList;

public class AdjacencyList {

	private LinkedList<Integer> graph[];

	@SuppressWarnings("unchecked")
	AdjacencyList(int countOfNodes) {

		graph = new LinkedList[countOfNodes];

		for (int i = 0; i < countOfNodes; i++) {
			graph[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int start, int end) {

		graph[start].add(end);
	}

	LinkedList<Integer> getConnectedNodes(int node) {

		return graph[node];
	}
}
