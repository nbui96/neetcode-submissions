/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        calculateHeight(root);
        return maxDiameter;
    }

    private int calculateHeight(TreeNode node) {
        if (node == null) return 0;

        int maxLeft = calculateHeight(node.left);
        int maxRight = calculateHeight(node.right);

        maxDiameter = Math.max(maxDiameter, maxLeft + maxRight);

        // Return height for parent calculations
        return Math.max(maxLeft, maxRight) + 1;
    }
}
