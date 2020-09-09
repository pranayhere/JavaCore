package com.pranay.interview.graphAll.bfs;

import com.pranay.GeeksForGeeks.Node;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class LonelyNodes {
    static Node root;
    public static void main(String[] args) {
        LonelyNodes ln = new LonelyNodes();
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);

        List<Integer> ans = getLonelyNodes(root);
        System.out.println("Lonely nodes are : " + ans);
    }

    private static List<Integer> getLonelyNodes(Node node) {
        List<Integer> ans = new ArrayList<>();

        Queue<Node> q = new ArrayDeque<>();
        q.offer(node);
        while(!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.left != null && curr.right != null) {
                q.offer(curr.left);
                q.offer(curr.right);
            }

            if (curr.left == null && curr.right != null) {
                ans.add(curr.right.data);
                q.offer(curr.right);
            }

            if (curr.right == null && curr.left != null) {
                ans.add(curr.left.data);
                q.offer(curr.left);
            }
        }
        return ans;
    }
}
