package com.pranay.interview.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
        left = null;
        right = null;
    }
}

public class TreeTopView {
    static TreeNode root;
    public static void main(String[] args) {
        root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeTopView tv = new TreeTopView();
        int[] ans = tv.findTopView(root);
        System.out.println(Arrays.toString(ans));
    }

    Map<Integer, Integer> hm = new HashMap<>(); // idx, val

    public int[] findTopView(TreeNode root) {
        topView(root, 0);

        int[][] res = new int[hm.size()][2];
        int i = 0;

        for (int k: hm.keySet()) {
            res[i][0] = k;
            res[i][1] = hm.get(k);
            i++;
        }

        Arrays.sort(res, (a, b) -> a[0] - b[0]);
        int[] ans = new int[res.length];

        i = 0;
        for (int[] r: res) {
            ans[i++] = r[1];
        }

        return ans;
    }

    public void topView(TreeNode root, int idx) {
        if (root == null)
            return;

        if (!hm.containsKey(idx)) {
            hm.put(idx, root.val);
        }

        topView(root.left, idx - 1);
        topView(root.right, idx + 1);
    }
}
