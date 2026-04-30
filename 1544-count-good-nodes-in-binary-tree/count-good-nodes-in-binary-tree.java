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
    public int goodNodes(TreeNode root) {

        return dfs(root, root.val);
        
    }

    public static int dfs(TreeNode root, int pathMax){
        if(root==null) return 0;

        int count=0;

        if(root.val>=pathMax){
            count++;
            pathMax=Math.max(root.val, pathMax);
        }

        count+= dfs(root.left, pathMax);
        count+= dfs(root.right, pathMax);

        return count;
    }
}