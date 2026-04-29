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
    public TreeNode convertBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        collect(root, list);
        update(root, list);

        return root;
    }

    public void collect(TreeNode root, List<Integer> list) {
        if (root == null)
            return;
        list.add(root.val);
        collect(root.left, list);
        collect(root.right, list);
        
    }

    public void update(TreeNode root, List<Integer> list) {

        if (root == null)
            return;

        int sum = 0;
        for (int val : list) {
            if (val > root.val) {
                sum += val;
            }
        }

        root.val += sum;

        update(root.left, list);
        update(root.right, list);
    }

}