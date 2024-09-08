package com.pranay.interview.graph;

import java.sql.Array;
import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    public static void main(String[] args) {
        Node n1 = new Node(1, new ArrayList<>());
        Node n2 = new Node(2, new ArrayList<>());
        Node n3 = new Node(3, new ArrayList<>());
        Node n4 = new Node(4, new ArrayList<>());

        n1.neighbors.add(n2);
        n1.neighbors.add(n4);

        n2.neighbors.add(n1);
        n2.neighbors.add(n3);

        n3.neighbors.add(n2);
        n3.neighbors.add(n4);

        n4.neighbors.add(n1);
        n4.neighbors.add(n3);

        CloneGraph cg = new CloneGraph();
        Node cloned = cg.cloneGraph(n1);

        System.out.println(cloned);

        Node cloned2 = cg.cloneGraphBFS(cloned);
        System.out.println(cloned2);
    }

    Map<Integer, Node> hm = new HashMap<>();

    public Node cloneGraph(Node node) {
        return dfs(node);
    }

    public Node dfs(Node node) {
        if (node == null)
            return null;

        if (hm.containsKey(node.val)) {
            return hm.get(node.val);
        }

        Node copy = new Node(node.val, new ArrayList<>());
        hm.put(node.val, copy);

        for (Node next: node.neighbors) {
            copy.neighbors.add(dfs(next));
        }

        return copy;
    }

    public Node cloneGraphBFS(Node node) {
        if (node == null)
            return null;

        Map<Node, Node> visited = new HashMap<>();
        Queue<Node> q = new ArrayDeque<>();
        q.offer(node);

        visited.put(node, new Node(node.val, new ArrayList<>()));

        while (!q.isEmpty()) {
            Node curr = q.poll();

            for (Node neigh: curr.neighbors) {
                if (!visited.containsKey(neigh)) {
                    visited.put(neigh, new Node(neigh.val, new ArrayList<>()));
                    q.offer(neigh);
                }

                visited.get(curr).neighbors.add(visited.get(neigh));
            }
        }

        return visited.get(node);
    }
}
