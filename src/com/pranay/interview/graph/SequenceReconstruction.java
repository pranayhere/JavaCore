package com.pranay.interview.graph;

import java.util.*;

/**
 * 444. Sequence Reconstruction
 * https://leetcode.com/problems/sequence-reconstruction/
 */
public class SequenceReconstruction {
    public static void main(String[] args) {
        int[] org = {4,1,5,2,6,3};
        List<List<Integer>> seqs = new ArrayList<>();
        seqs.add(Arrays.asList(5,2,6,3));
        seqs.add(Arrays.asList(4,1,5,2));

        SequenceReconstruction sr = new SequenceReconstruction();
        boolean ans = sr.sequenceReconstruction(org, seqs);
        System.out.println("Ans : " + ans);
    }

    Map<Integer, List<Integer>> graph = new HashMap<>();
    Map<Integer, Integer> indegree = new HashMap<>();

    private boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        // build graph
        for (List<Integer> seq : seqs) {
            for(int i = 0; i < seq.size(); i++) {
                indegree.putIfAbsent(seq.get(i), 0);
                graph.putIfAbsent(seq.get(i), new ArrayList<>());
            }
        }

        for (List<Integer> seq: seqs) {
            for (int i = 0; i < seq.size() - 1; i++) {
                Integer parent = seq.get(i);
                Integer child = seq.get(i + 1);

                graph.get(parent).add(child);
                indegree.put(child, indegree.get(child) + 1);
            }
        }
        System.out.println(indegree);
        System.out.println(graph);

        if (indegree.size() != org.length)
            return false;


        // topological Sort
        Queue<Integer> q = new ArrayDeque<>();
        int[] res = new int[org.length];

        for (Integer node: graph.keySet()) {
            if (indegree.get(node) == 0) {
                q.offer(node);
            }
        }

        int index = 0;
        while (!q.isEmpty()) {
            if (q.size() > 1) // specific to example, 2 numbers to start with hence false;
                return false;

            int num = q.poll();
            res[index++] = num;

            for (int i: graph.get(num)) {
                indegree.put(i, indegree.get(i) - 1);
                if (indegree.get(i) == 0)
                    q.offer(i);
            }
        }

        for (int i = 0; i < org.length; i++) {
            if (res[i] != org[i])
                return false;
        }
        return true;
    }
}
