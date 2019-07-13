package graph;

public class AdjancencyMatrix {

	private int[][] graph;

	AdjancencyMatrix(int countOfNodes) {
		
		graph = new int[countOfNodes][countOfNodes];
	}
	
	void addEdge(int start, int end) {
		
		graph[start][end] = 1;
	}
	
	int[] getConnectedNodes(int node) {
		
		return graph[node];
	}

}
