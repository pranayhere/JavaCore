package com.pranay.interview.trie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryFileSystem {
    public static void main(String[] args) {
        InMemoryFileSystem fs = new InMemoryFileSystem();
//        System.out.println(fs.ls("/"));
//        fs.mkdir("/a/b/c");
//        fs.addContentToFile("/a/b/c/d","hello");
//        System.out.println(fs.ls("/"));
//        System.out.println(fs.readContentFromFile("/a/b/c/d"));

//        fs.mkdir("/goowmfn");
//        fs.ls("/goowmfn");
//        fs.ls("/");
//        fs.mkdir("/z");
//        fs.ls("/");
//        fs.ls("/");
//        fs.addContentToFile("/goowmfn/c","shetopcy");
//        fs.ls("/z");
//        fs.ls("/goowmfn/c");
//        fs.ls("/goowmfn");

//        ["FileSystem","mkdir","ls","mkdir","ls","ls","ls","addContentToFile","ls","ls","ls"]
//        [[],["/m"],["/m"],["/w"],["/"],["/w"],["/"],["/dycete","emer"],["/w"],["/"],["/dycete"]]

        fs.mkdir("/m");
        System.out.println(fs.ls("/m"));
        fs.mkdir("/w");
        System.out.println(fs.ls("/"));
        System.out.println(fs.ls("/w"));
        System.out.println(fs.ls("/"));
        fs.addContentToFile("/dycete","emer");
        System.out.println(fs.ls("/w"));
        System.out.println(fs.ls("/"));
        System.out.println(fs.ls("/dycete"));
    }

    static class TrieNode {
        Map<String, TrieNode> nodes;
        Map<String, String> files;
        boolean isEnd;

        public TrieNode() {
            nodes = new HashMap<>();
            files = new HashMap<>();
            isEnd = false;
        }
    }

    TrieNode root;

    public InMemoryFileSystem() {
        root = new TrieNode();
    }

    public List<String> ls(String path) {
        List<String> ans = new ArrayList<>();

        TrieNode node = root;
//        System.out.println(node.nodes.keySet());
        String[] dirs = path.split("/");

        for (String dir: dirs) {
            if (dir.equals(""))
                continue;

            if (node.nodes.containsKey(dir))
                node = node.nodes.get(dir);
        }

        for (String dir: node.nodes.keySet())
            ans.add(dir);

        for (String file: node.files.keySet())
            ans.add(file);

        Collections.sort(ans, (a, b) -> a.compareTo(b));
        return ans;
    }

    public void mkdir(String path) {
        TrieNode node = root;
        String[] dirs = path.split("/");

        for (String dir: dirs) {
            if (dir.equals(""))
                continue;

            if (!node.nodes.containsKey(dir)) {
                node.nodes.put(dir, new TrieNode());
            }

            node = node.nodes.get(dir);
        }

        node.isEnd = true;
    }

    public void addContentToFile(String filePath, String content) {
        TrieNode node = root;
        String[] path = filePath.split("/");

        for (int i = 0; i < path.length - 1; i++) {
            if (node.nodes.containsKey(path[i]))
                node = node.nodes.get(path[i]);
        }

        String fileName = path[path.length - 1];

        node.files.put(fileName, node.files.getOrDefault(fileName, "") + content);
    }

    public String readContentFromFile(String filePath) {
        TrieNode node = root;
        String[] path = filePath.split("/");

        for (int i = 0; i < path.length - 1; i++) {
            if (node.nodes.containsKey(path[i]))
                node = node.nodes.get(path[i]);
        }

        String fileName = path[path.length - 1];
        return node.files.getOrDefault(fileName, "");
    }
}
