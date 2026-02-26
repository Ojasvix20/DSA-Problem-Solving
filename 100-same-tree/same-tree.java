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
// class Solution {
//     public boolean isSameTree(TreeNode p, TreeNode q) {
//         Queue<TreeNode> q1 = new LinkedList<>();
//         Queue<TreeNode> q2 = new LinkedList<>();

//         q1.offer(p);
//         q2.offer(q);

//         while(!q1.isEmpty() && !q2.isEmpty()){
//             TreeNode curr1 = q1.poll();
//             TreeNode curr2 = q2.poll();

//             // if both null -- ok 
//             if (curr1 == null && curr2 == null) continue;

//             // if one null --- not same
//             if (curr1 == null || curr2 == null) return false;

//             if(curr1.val!= curr2.val) return false;

//             q1.offer(curr1.left);
//             q1.offer(curr1.right);
//             q2.offer(curr2.left);
//             q2.offer(curr2.right);
//         }
//         if(!q1.isEmpty() || !q2.isEmpty()) return false;
//         return true;
//     }
// }

//easier:
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left)
            && isSameTree(p.right, q.right);
    }
}