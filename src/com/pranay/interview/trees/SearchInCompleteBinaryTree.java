package com.pranay.interview.trees;
// Search in a Virtually Complete Binary Tree
// https://binarysearch.com/problems/Search-in-a-Virtually-Complete-Binary-Tree
// Intuition
//        Get the log2 value of target.
//        log2(1) = 0.0
//        log2(2) = 1.0
//        log2(4) = 2.0
//        log2(8) = 3.0
//        log2(16) = 4.0..
//        Values in between lie in between them, so we can easily know which level of tree target can exist since the condition provided is it was a complete binary tree.
//
//        Now, if you look more closely,
//        log2(3) = 1.58..
//        log2(5) = 2.32...
//        log2(6) = 2.58...
//        1 is at root of the tree.
//        2 and 3 are left and right subtrees with log2 values 1.0 and 1.58..
//        4,5 are left subtrees of 2 with log2 values 2.0 and 2.32..
//        6,7 are right subtrees of 3 with log2 values 2.58.. and 2.80..
//        So, if target is more than half then we should traverse to right subtree, otherwise left subtree.
//
//        Implementation
//        Because of the constraints of the problem that it was a complete binary tree, you can do following -
//
//        Find the log2 value of target.
//        Integer part will tell you which level of the tree target can be present.
//        We are interested in the decimal part in order to determine left or right subtree while traversing the tree.
//        Then it is kind of binary search. At each level, determine if the target value is higher than mid value, then we need to go to right subtree. Otherwise left subtree.
//        Time Complexity
//        Since you will only traverse to either left or right subtree at any level. \mathcal{O}(\log n )O(logn)
//
//        Space Complexity
//        Constant space throughout the program. You are just saving some intermediate variables left and right. \mathcal{O}(1)O(1)
//

class Tree {
    int val;
    Tree left;
    Tree right;
}

public class SearchInCompleteBinaryTree {
    public boolean solve(Tree root, int target) {
        double targetValLog2 = Math.log(target) / Math.log(2);
        double targetDecimal = targetValLog2 - (int) targetValLog2;
        double left = 0.0, right = 1.0;

        while (root != null) {
            if (root.val == target) {
                return true;
            }

            double mid = (left + right) / 2.0;

            if (targetDecimal >= mid) {
                root = root.right;
                left = mid;
            } else {
                root = root.left;
                right = mid;
            }
        }

        return false;
    }
}
