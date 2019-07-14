package graph;

/*
 * Given a graph G and an integer K, K-cores of the graph are connected components 
 * that are left after all vertices of degree less than k have been removed 
 * (Source https://en.wikipedia.org/wiki/Degeneracy_%28graph_theory%29)
 * 
 * i.e. if k is 3 then all nodes with less than 3 edges to be removed
 * 
 */
public class K_CoreUndirected {

	public static void main(String[] args) {
		AdjacencyList graph = new AdjacencyList(7);
		graph.bootstrap();

		System.out.println(graph.getConnectedNodes(0));
		System.out.println(graph.getConnectedNodes(1));
		System.out.println(graph.getConnectedNodes(2));
		System.out.println(graph.getConnectedNodes(3));
		System.out.println(graph.getConnectedNodes(4));
		System.out.println(graph.getConnectedNodes(5));

	}

}
