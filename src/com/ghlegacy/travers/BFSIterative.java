package com.ghlegacy.travers;

import java.util.*;

class BFSIterative
{
	// Perform BFS on graph starting from vertex v
	public static void BFSIterative(Graph graph, int v, boolean[] discovered)
	{
		// create a queue used to do BFS
		Queue<Integer> q = new ArrayDeque<>();

		// mark source vertex as discovered
		discovered[v] = true;

		// push source vertex into the queue
		q.add(v);

		// run till queue is not empty
		while (!q.isEmpty())
		{
			// pop front node from queue and print it
			v = q.poll();
			System.out.print(v + " ");

			// do for every edge (v -> u)
			for (int u : graph.adjList.get(v)) {
				if (!discovered[u]) {
					// mark it discovered and push it into queue
					discovered[u] = true;
					q.add(u);
				}
			}
		}
	}

	// Iterative Java implementation of Breadth first search
	public static void main(String[] args)
	{
		// List of graph edges as per above diagram
		List<Edge> edges = Arrays.asList(
				new Edge(1, 2), new Edge(1, 3), new Edge(1, 4),
				new Edge(2, 5), new Edge(2, 6), new Edge(5, 9),
				new Edge(5, 10), new Edge(4, 7), new Edge(4, 8),
				new Edge(7, 11), new Edge(7, 12)
				// vertex 0, 13 and 14 are single nodes
		);

		// Set number of vertices in the graph
		final int N = 15;

		// create a graph from edges
		Graph graph = new Graph(edges, N);

		// stores vertex is discovered or not
		boolean[] discovered = new boolean[N];

		// Do BFS traversal from all undiscovered nodes to
		// cover all unconnected components of graph
		for (int i = 0; i < N; i++) {
			if (discovered[i] == false) {
				// start BFS traversal from vertex i
				BFSIterative(graph, i, discovered);
			}
		}
	}
}