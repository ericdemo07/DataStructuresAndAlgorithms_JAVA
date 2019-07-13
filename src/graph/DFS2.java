package graph;

public class DFS2 {
	
	public static void main(String... args) {
		
		AdjacencyList graph = new AdjacencyList(9);
		
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);

		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		
		graph.addEdge(3, 5);
		graph.addEdge(3, 7);
		graph.addEdge(3, 8);
	}
	
	void traverseutil() {
		
	}
	
	void traverse(AdjacencyList graph, int countOfNodes) {
		
		boolean[] explored = new boolean[countOfNodes];
		
	}

}
