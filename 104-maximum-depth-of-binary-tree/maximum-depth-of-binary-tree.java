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
    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;
        int level = 0;
        level=dfs(root);

        return level+1;
    }

    public static int dfs(TreeNode node) {
        if(node==null) return 0;
        int left = 0;
        if (node.left != null) {
            left = 1 + dfs(node.left);
        }
        int right = 0;
        if (node.right != null) {
            right = 1 + dfs(node.right);
        }
        return Math.max(right, left);
    }
}