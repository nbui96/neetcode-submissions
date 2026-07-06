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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return root;
        TreeNode result = new TreeNode(root.val);
        invertTreeHelper(root, result);
        return result;
    }

    private void invertTreeHelper(TreeNode root, TreeNode result) {
        if (root == null) return;

        if (root.left != null) {
            result.right = new TreeNode(root.left.val);
            invertTreeHelper(root.left, result.right);
        }

        if (root.right != null) {
            result.left = new TreeNode(root.right.val);
            invertTreeHelper(root.right, result.left);
        }

    }
}
