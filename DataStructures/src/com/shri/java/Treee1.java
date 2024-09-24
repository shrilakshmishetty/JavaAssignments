//Q7: Write a program to find the maximum path sum from given a binary tree.
package com.shri.java;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class Treee1 {

    static class Result {
        int maxPathSum;

        Result() {
            maxPathSum = Integer.MIN_VALUE;
        }
    }

    public static int maxPathSum(TreeNode root) {
        Result result = new Result();
        maxPathSumUtil(root, result);
        return result.maxPathSum;
    }

    private static int maxPathSumUtil(TreeNode node, Result result) {
        if (node == null) {
            return 0;
        }
        int left = Math.max(0, maxPathSumUtil(node.left, result));
        int right = Math.max(0, maxPathSumUtil(node.right, result));
        int maxThroughNode = node.val + left + right;
        result.maxPathSum = Math.max(result.maxPathSum, maxThroughNode);
        return node.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int maxSum = maxPathSum(root);
        System.out.println("Maximum Path Sum: " + maxSum);
    }
}
