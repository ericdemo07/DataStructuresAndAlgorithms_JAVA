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

	void deleteNode(int node) {
		graph[node] = new LinkedList<Integer>();

		for (int i = 0; i < graph.length; i++) {
			graph[i].removeIf(e -> e == node);
		}
	}

	void bootstrap() {
		graph[0].add(1);
		graph[0].add(2);

		graph[1].add(3);
		graph[1].add(4);

		graph[2].add(4);
		graph[2].add(5);
		graph[2].add(6);

		//
		graph[1].add(0);
		graph[2].add(0);

		graph[3].add(1);
		graph[4].add(1);

		graph[4].add(2);
		graph[5].add(2);
		graph[6].add(2);
	}
}
