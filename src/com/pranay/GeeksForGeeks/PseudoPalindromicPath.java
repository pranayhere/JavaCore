package com.pranay.GeeksForGeeks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PseudoPalindromicPath {

    int cnt;

    public PseudoPalindromicPath() {
        cnt = 0;
    }

    static Node root;

    public static void main(String[] args) {
        PseudoPalindromicPath tree = new PseudoPalindromicPath();
        root = new Node(8);
        root.left = new Node(8);
        root.left.left = new Node(7);
        root.left.right = new Node(7);
        root.left.right.left = new Node(2);
        root.left.right.right = new Node(4);
        root.left.right.left.right = new Node(8);
        root.left.right.left.right.right = new Node(1);
        root.left.right.right = new Node(4);
        root.left.right.right.right = new Node(7);

        int count = tree.pseudoPalindromicPaths(root);
        System.out.println("Count : " + count);
    }

    private int pseudoPalindromicPaths(Node node) {
        dfs(node, new ArrayList<>());
        return cnt;
    }

    private void dfs(Node node, List<Integer> list) {
        if (node == null) {
            return;
        }

        list.add(node.data);

        if (node.left == null && node.right == null) {
            if (isPalindrome(list)) {
                cnt++;
            }
        } else {
            dfs(node.left, new ArrayList<>(list));
            dfs(node.right, new ArrayList<>(list));
        }
    }

    private boolean isPalindrome(List<Integer> list) {
        Set<Integer> hs = new HashSet<>();

        for (Integer num: list) {
            if (hs.contains(num)) {
                hs.remove(num);
            } else {
                hs.add(num);
            }
        }

        if (hs.size() == 0 || hs.size() == 1)
            return true;
        return false;
    }

    public int pseudoPalindromicPaths(TreeNode root) {
        return canBePalindrome(root, new HashSet<>());
    }

    private int canBePalindrome(TreeNode node, Set<Integer> numbers) {
        if (node == null) return 0;
        if (numbers.contains(node.val)) {
            numbers.remove(node.val);
        } else {
            numbers.add(node.val);
        }
        if (node.left == null && node.right == null) {
            return numbers.size() == 0 || numbers.size() == 1 ? 1 : 0;
        }
        int left = canBePalindrome(node.left, new HashSet(numbers));
        int right = canBePalindrome(node.right, new HashSet(numbers));
        return left + right;
    }
}
