package graph;

/*
 * A mother vertex in a graph G = (V,E) is a vertex v such that 
 * all other vertices in G can be reached by a path from v.
 * 
 * 1. Undirected Connected graph has all vertices are mother vetice
 * 2. Undirected/Directed Disconnected graph has none
 * 3. Directed Connected Graph has one
 */
public class MotherNode {

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
