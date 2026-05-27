class Solution {
    static Map<TreeNode, Integer> map;

    public int rob(TreeNode root) {
        map = new HashMap<>();
        return solve(root);
    }

    public int solve(TreeNode curr) {
        if (curr == null)
            return 0;

        if (map.containsKey(curr))
            return map.get(curr);

        int take = curr.val;

        if (curr.left != null) {
            take += solve(curr.left.left);
            take += solve(curr.left.right);
        }

        if (curr.right != null) {
            take += solve(curr.right.left);
            take += solve(curr.right.right);
        }

        int notTake = solve(curr.left) + solve(curr.right);
        int ans =Math.max(take, notTake);
        map.put(curr,ans );
        return ans;
    }
}