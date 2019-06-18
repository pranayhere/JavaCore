package com.pranay.GeeksForGeeks;

import java.util.LinkedList;

import com.pranay.CombinedCollections.HashMap_ArrayList_Demo;

enum State { Unvisited, Visited, Visiting; }

class Graph {
	public GraphNode[] node;

	public GraphNode[] getNodes() {
		return node;
	}

	public void setNode(GraphNode[] node) {
		this.node = node;
	}
}

class GraphNode {
	public String name;
	public State state;
	public GraphNode[] children;
	
	public GraphNode[] getAdjacent() {
		return children;
	}
}

public class GraphRouteBtwTwoNodes {

	public static void main(String[] args) {
	//	build a graph here
	}
	
	boolean search(Graph g, GraphNode start, GraphNode end) {
		if (start == end)
			return true;
		
		LinkedList<GraphNode> q = new LinkedList<GraphNode>();
		
		for (GraphNode u : g.getNodes()) {
			u.state = State.Unvisited;
		}
		
		start.state = State.Visiting;
		q.add(start);
		
		GraphNode u;
		
		while (!q.isEmpty()) {
			u = q.removeFirst();
			if (u != null) {
				for (GraphNode v : u.getAdjacent()) {
					if (v.state == State.Unvisited) {
						if (v == end)
							return true;
						else {
							v.state = State.Visiting;
							q.add(v);
						}
					}
				}
				u.state = State.Visited;
			}
		}
		return false;
	} 
}
