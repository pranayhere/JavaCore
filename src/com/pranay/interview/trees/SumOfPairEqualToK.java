package com.pranay.interview.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the BST and value K, you have to find the Pairs whose sum is equal to K
 * Ex : Given following BST and K = 5
 *           6
 *         /  \
 *        3    8
 *       / \
 *      2   4
 *  op: 1
 *  Explaination: {2, 3}
 *
 *  Ex2 : K = 6
 *        1
 *         \
 *          2
 *           \
 *            3
 *             \
 *              4
 *               \
 *                5
 *                 \
 *                  6
 * op: 2
 * Explaination: {2, 4} {1, 5}
 */

public class SumOfPairEqualToK {
	static Node root;
    public static void main(String[] args) {
        SumOfPairEqualToK tree = new SumOfPairEqualToK();
        root = new Node(6);
        root.left = new Node(3);
        root.right = new Node(8);
        root.left.left = new Node(2);
        root.left.right = new Node(4);

        int k = 5;

        List<List<Integer>> pairs = findPairs(root, k);
        System.out.println(pairs);
    }

    private static List<List<Integer>> findPairs(Node node, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(node, nums);
        List<List<Integer>> ans = findPairsInList(nums, k);
        return ans;
    }

    private static List<List<Integer>> findPairsInList(List<Integer> nums, int k) { // just solve it as Two sum problem
        List<List<Integer>> pairs = new ArrayList<>();
        int lo = 0;
        int hi = nums.size() - 1;
        while (lo < hi) {
            int sum = nums.get(lo) + nums.get(hi);
            if (sum == k) {
                List<Integer> pair = new ArrayList<>();
                pair.add(nums.get(lo));
                pair.add(nums.get(hi));
                pairs.add(pair);
            }
            if (sum > k)
                hi--;
            else
                lo++;
        }
        return pairs;
    }

    private static void inorder(Node node, List<Integer> nums) {
        if (node == null)
            return;
        inorder(node.left, nums);
        nums.add(node.data);
        inorder(node.right, nums);
    }
}
