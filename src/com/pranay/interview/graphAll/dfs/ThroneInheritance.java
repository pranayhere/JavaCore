package com.pranay.interview.graphAll.dfs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThroneInheritance {
    Map<String, List<String>> family = new HashMap<>();
    Set<String> dead = new HashSet<>();
    String root;

    public ThroneInheritance(String king) {
        root = king;
    }

    public void birth(String parentName, String childName) {
        family.computeIfAbsent(parentName, k -> new ArrayList<>()).add(childName);
    }

    public void death(String name) {
        dead.add(name);
    }

    public List<String> getInheritanceOrder() {
        List<String> list = new ArrayList<>();
        dfs("king", list);
        return list;
    }

    private void dfs(String parent, List<String> res) {
        if (!dead.contains(parent))
            res.add(parent);

        if (!family.containsKey(parent))
            return;

        for (String child: family.get(parent))
            dfs(child, res);
    }

    public static void main(String[] args) {
        ThroneInheritance ti = new ThroneInheritance("king");
        ti.birth("king", "Alice");
        ti.birth("king", "Bob");
        ti.birth("Alice", "Jack");
        System.out.println(ti.getInheritanceOrder());
    }
}
