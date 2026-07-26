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
    int result;

    public int countDominantNodes(TreeNode root) {
        result = 0;

        traversal(root);

        return result;
    }

    public int traversal(TreeNode root) {
        if (root == null) {
            //means leaf node
            return Integer.MIN_VALUE;
        }
        int left = traversal(root.left);
        int right = traversal(root.right);
        if (root.val >= Math.max(left, right))
            result++;

        return Math.max(root.val, Math.max(left, right));

    }
}