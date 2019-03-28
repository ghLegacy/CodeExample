package com.ghlegacy.dijkstra;

import java.util.HashSet;
import java.util.Set;

public class Graph {
	 
    private Set<Node> nodes = new HashSet<>();
     
    public void addNode(Node nodeA) {
        nodes.add(nodeA);
    }
     
    public String toString()
    {
		String nodeNames = "Names:";
    	for (Node n : nodes )
    	{
			nodeNames = nodeNames + " -> " + n.getName();
		}
    	return nodeNames;
    }
   
 
    // getters and setters 
}
