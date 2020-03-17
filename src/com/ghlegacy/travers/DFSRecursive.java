package com.ghlegacy.travers;

import java.util.*;

class DFSRecursive
{
	// Function to perform DFS Traversal
	public static void DepthFirstSearch(Graph graph, int v, boolean[] discovered)
	{
		// mark current node as discovered
		discovered[v] = true;

		// print current node
		System.out.print(v + " ");

		// do for every edge (v -> u)
		for (int u : graph.adjList.get(v))
		{
			// u is not discovered
			if (!discovered[u]) {
				DepthFirstSearch(graph, u, discovered);
			}
		}
	}

	// Recursive Java implementation of Depth first search
	public static void main(String[] args)
	{
		// List of graph edges as per above diagram
		List<Edge> edges = Arrays.asList(
				// Notice that node 0 is unconnected node
				new Edge(1, 2), new Edge(1, 7), new Edge(1, 8),
				new Edge(2, 3), new Edge(2, 6), new Edge(3, 4),
				new Edge(3, 5), new Edge(8, 9), new Edge(8, 12),
				new Edge(9, 10), new Edge(9, 11)
		);

		// Set number of vertices in the graph (0-12)
		final int N = 13;

		// create a graph from edges
		Graph graph = new Graph(edges, N);

		// stores vertex is discovered or not
		boolean[] discovered = new boolean[N];

		// Do DFS traversal from all undiscovered nodes to
		// cover all unconnected components of graph
		for (int i = 0; i < N; i++) {
			if (!discovered[i]) {
				DepthFirstSearch(graph, i, discovered);
			}
		}
	}
}