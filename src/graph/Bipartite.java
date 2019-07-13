package graph;

import java.util.Iterator;
import java.util.LinkedList;

public class Bipartite {

	private int countOfNodes;
	private AdjacencyList graph;

	Bipartite() {
		countOfNodes = 9;
	}

	public static void main(String[] args) {
		Bipartite bipartite = new Bipartite();

		bipartite.graph = new AdjacencyList(bipartite.countOfNodes);
		//
		 bipartite.graph.addEdge(1, 2);
		 bipartite.graph.addEdge(1, 3);
		
		 bipartite.graph.addEdge(2, 4);
		 bipartite.graph.addEdge(2, 5);
		
		 bipartite.graph.addEdge(3, 5);
		 bipartite.graph.addEdge(3, 7);
		 bipartite.graph.addEdge(3, 8);
		 bipartite.graph.addEdge(4, 5);

//		bipartite.graph.addEdge(1, 2);
//		bipartite.graph.addEdge(2, 3);
//
//		bipartite.graph.addEdge(3, 4);
//
//		bipartite.graph.addEdge(4, 5);
//		bipartite.graph.addEdge(5, 6);

		bipartite.isBipartite(bipartite.graph, 1, bipartite.countOfNodes);

	}

	boolean isBipartite(AdjacencyList graph, int start, int countOfNodes) {

		boolean[] discovered = new boolean[countOfNodes];
		// boolean[] bipartite = new boolean[countOfNodes];

		LinkedList<Test> integers = new LinkedList<Test>();

		Test test1 = new Test();
		test1.node = start;
		test1.color = "red";

		integers.add(test1);

		discovered[start] = true;

		LinkedList<Test>[] layers = new LinkedList[countOfNodes];
		layers[0] = integers;

		int i = 0;

		while (layers[i].size() != 0) {
			LinkedList<Test> emptyList = new LinkedList<Test>();

			Iterator<Test> test = layers[i].listIterator();
			i = i + 1;

			while (test.hasNext()) {
				Iterator<Integer> iterator = graph.getConnectedNodes(test.next().node).listIterator();

				while (iterator.hasNext()) {
					int n = iterator.next();

					if (!discovered[n]) {
						discovered[n] = true;
						Test test11 = new Test();
						test11.node = n;
						if (i % 2 == 0) {
							test11.color = "red";
						} else {
							test11.color = "blue";
						}
						emptyList.add(test11);
					}
				}
			}
			layers[i] = emptyList;
		}

		// System.out.println("\n\ntest :" + layers);

		for (LinkedList<Test> a : layers) {
			while (a != null && !a.isEmpty()) {
				Test a1 = a.poll();
				System.out.print(" " + a1.node + ", " + a1.color + " ");
			}
			System.out.println();

		}
		return false;
	}

	private class Test {
		int node;
		String color;
	}

}
