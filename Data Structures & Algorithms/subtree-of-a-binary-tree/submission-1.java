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
    private boolean isSubtree = false;

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isSubtree) return true;
        
        if (root.val == subRoot.val) {
            isSubtree = isSameTree(root, subRoot);
        }
        if (root.left != null) {
            isSubtree(root.left, subRoot);
        }
        if (root.right != null) {
            isSubtree(root.right, subRoot);
        }
        return isSubtree;
    }

    private boolean isSameTree(TreeNode node, TreeNode subRoot) {
        if (subRoot == null && node == null) return true;
        if (subRoot == null || node == null) return false;
        if (subRoot.val != node.val) return false;

        return isSameTree(node.left, subRoot.left) && isSameTree(node.right, subRoot.right);
    }
}
