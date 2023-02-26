package com.pranay.interview.misc;

import java.util.*;

class Node {
    Map<String, Node> nodes; // tags
    Set<Integer> processes;

    public Node() {
        this.nodes = new HashMap<>();
        this.processes = new HashSet<>();
    }
}

public class PendencySystem {
    public static void main(String[] args) {
        Node root = new Node();
        PendencySystem ps = new PendencySystem();
        ps.startTracking(root,1112, new String[]{"UPI", "Karnataka", "Bangalore"});
        ps.startTracking(root,2451, new String[]{"UPI", "Karnataka", "Mysore"});
        ps.startTracking(root,3421, new String[]{"UPI", "Rajasthan", "Jaipur"});
        ps.startTracking(root,1221, new String[]{"Wallet", "Karnataka", "Bangalore"});

        System.out.println(ps.getCount(root, new String[]{"UPI"}));
        System.out.println(ps.getCount(root, new String[]{"UPI", "Karnataka"}));
        System.out.println(ps.getCount(root, new String[]{"UPI", "Karnataka", "Bangalore"}));

        System.out.println(ps.getCount(root, new String[]{"Bangalore"}));
        ps.startTracking(root,4221, new String[]{"Wallet", "Karnataka", "Bangalore"});

        ps.stopTracking(root,1112, new String[]{"UPI", "Karnataka", "Bangalore"});
        ps.stopTracking(root,2451, new String[]{"UPI", "Karnataka", "Mysore"});

        System.out.println(ps.getCount(root, new String[]{"UPI"}));
        System.out.println(ps.getCount(root, new String[]{"Wallet"}));
        System.out.println(ps.getCount(root, new String[]{"UPI", "Karnataka", "Bangalore"}));
    }

    private void startTracking(Node node, int process, String[] tags) {
        for (String tag: tags) {
            if (!node.nodes.containsKey(tag)) {
                node.nodes.put(tag, new Node());
            }
            node = node.nodes.get(tag);
            node.processes.add(process);
        }
    }

    private Integer getCount(Node node, String[] tags) {
        for (String tag: tags) {
            if (node.nodes.containsKey(tag))
                node = node.nodes.get(tag);
            else
                return 0;
        }

        return node.processes.size();
    }

    private void stopTracking(Node node, int process, String[] tags) {
        for (String tag: tags) {
            if (node.nodes.containsKey(tag)) {
                node = node.nodes.get(tag);
                node.processes.remove(process);
            }
        }
    }
}
