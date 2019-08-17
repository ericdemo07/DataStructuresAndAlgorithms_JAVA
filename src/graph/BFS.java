package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	private static int countOfNodes;
	static AdjacencyList graph;

	BFS() {
		countOfNodes = 9;
	}

	public static void main(String[] args) {

		new BFS();
		graph = new AdjacencyList(countOfNodes);

		graph.addEdge(1, 2);
		graph.addEdge(1, 3);

		graph.addEdge(2, 4);
		graph.addEdge(2, 5);

		graph.addEdge(3, 5);
		graph.addEdge(3, 8);
		graph.addEdge(3, 7);

		search(1);
	}

	private static void search(int start) {
		boolean discovered[] = new boolean[countOfNodes];
		Queue<Integer> queue = new LinkedList<Integer>();
		discovered[start] = true;
		queue.add(start);

		while (queue.size() != 0) {

			start = queue.poll();

			System.out.println(start + "");

			Iterator<Integer> iterator = graph.getConnectedNodes(start).listIterator();

			while (iterator.hasNext()) {
				int n = iterator.next();
				
				if (!discovered[n]) {
					discovered[n] = true;
					queue.add(n);
				}
			}
		}

	}

}
