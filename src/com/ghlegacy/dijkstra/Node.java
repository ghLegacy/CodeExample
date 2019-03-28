package com.ghlegacy.dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Node {
    
    private String name;
     
    private List<Node> shortestPath = new LinkedList<>();
     
    private Integer distance = Integer.MAX_VALUE;
     
    Map<Node, Integer> adjacentNodes = new HashMap<>();
 
    public void addDestination(Node destination, int distance) {
        adjacentNodes.put(destination, distance);
    }
  
    public Node(String name) {
        this.setName(name);
    }

	public int getDistance() {
		return distance;
	}

	public void setDistance(int i) {
		distance = i;
	}

	public Map<Node, Integer> getAdjacentNodes() {
		// TODO Auto-generated method stub
		return adjacentNodes;
	}

	public List getShortestPath() {
		// TODO Auto-generated method stub
		return shortestPath;
	}

	public void setShortestPath(LinkedList<Node> aShortestPath) {
		shortestPath = aShortestPath;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
     
}
