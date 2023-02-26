package com.pranay.interview.trie;

import java.util.*;
class PendencyNode {
    Map<String, PendencyNode> nodes; // tags
    Set<Integer> processes;

    public PendencyNode() {
        this.nodes = new HashMap<>();
        this.processes = new HashSet<>();
    }
}

public class PendencySystem {
    public static void main(String[] args) {
        PendencyNode root = new PendencyNode();
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

    private void startTracking(PendencyNode pendencyNode, int process, String[] tags) {
        for (String tag: tags) {
            if (!pendencyNode.nodes.containsKey(tag)) {
                pendencyNode.nodes.put(tag, new PendencyNode());
            }
            pendencyNode = pendencyNode.nodes.get(tag);
            pendencyNode.processes.add(process);
        }
    }

    private Integer getCount(PendencyNode pendencyNode, String[] tags) {
        for (String tag: tags) {
            if (pendencyNode.nodes.containsKey(tag))
                pendencyNode = pendencyNode.nodes.get(tag);
            else
                return 0;
        }

        return pendencyNode.processes.size();
    }

    private void stopTracking(PendencyNode pendencyNode, int process, String[] tags) {
        for (String tag: tags) {
            if (pendencyNode.nodes.containsKey(tag)) {
                pendencyNode = pendencyNode.nodes.get(tag);
                pendencyNode.processes.remove(process);
            }
        }
    }
}
