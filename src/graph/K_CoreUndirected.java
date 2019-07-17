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
		int countOfNodes = 7, k = 3;
		AdjacencyList graph = new AdjacencyList(countOfNodes);
		graph.bootstrap();

		// graph.deleteNode(0);
		System.out.println(graph.getConnectedNodes(0) + "  " + graph.getConnectedNodes(0).size());
		System.out.println(graph.getConnectedNodes(1) + "  " + graph.getConnectedNodes(1).size());
		System.out.println(graph.getConnectedNodes(2) + "  " + graph.getConnectedNodes(2).size());
		System.out.println(graph.getConnectedNodes(3) + "  " + graph.getConnectedNodes(3).size());
		System.out.println(graph.getConnectedNodes(4) + "  " + graph.getConnectedNodes(4).size());
		System.out.println(graph.getConnectedNodes(5) + "  " + graph.getConnectedNodes(5).size());
		System.out.println(graph.getConnectedNodes(6) + "  " + graph.getConnectedNodes(6).size());

		System.out.println("\n\n");
		for (int i = 0; i < countOfNodes; i++) {
			System.out.println(graph.getConnectedNodes(i).size() + "  " + i);

			if (graph.getConnectedNodes(i).size() < k) {
				graph.deleteNode(i);
			}
			else {
				System.out.println("hello :"+i);

			}
		}

		System.out.println();
		System.out.println();

		System.out.println(graph.getConnectedNodes(0) + "  " + graph.getConnectedNodes(0).size());
		System.out.println(graph.getConnectedNodes(1) + "  " + graph.getConnectedNodes(1).size());
		System.out.println(graph.getConnectedNodes(2) + "  " + graph.getConnectedNodes(2).size());
		System.out.println(graph.getConnectedNodes(3) + "  " + graph.getConnectedNodes(3).size());
		System.out.println(graph.getConnectedNodes(4) + "  " + graph.getConnectedNodes(4).size());
		System.out.println(graph.getConnectedNodes(5) + "  " + graph.getConnectedNodes(5).size());
		System.out.println(graph.getConnectedNodes(6) + "  " + graph.getConnectedNodes(6).size());

	}

}
