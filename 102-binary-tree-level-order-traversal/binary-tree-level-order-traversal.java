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
    public List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> q = new ArrayDeque<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return new ArrayList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            ans.add(new ArrayList<>());
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                if (curr.left != null)
                    q.offer(curr.left);
                if (curr.right != null)
                    q.offer(curr.right);
                ans.get(ans.size() - 1).add(curr.val);
            }
        }
        return ans;
    }
}