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

    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
    private int dfs(TreeNode root) {

        if(root ==  null) return 0;

        int ls = Math.max(dfs(root.left),0);
        int rs = Math.max(dfs(root.right),0);

        int totSum = root.val + ls + rs;

         maxSum = Math.max(totSum, maxSum);

         return root.val + Math.max(ls,rs);
    }
}