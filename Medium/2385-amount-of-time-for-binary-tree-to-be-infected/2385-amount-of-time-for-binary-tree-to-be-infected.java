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
    public int amountOfTime(TreeNode root, int start) {
       int[] maxTime = new int[1];

        burn(root, maxTime, start);

        return maxTime[0];
    }
    private int burn(TreeNode root, int[] maxTime, int start){
        if (root == null) return 0;

        if(root.val == start){
            maxTime[0] = Math.max(maxTime[0], getHeight(root)-1);
            return -1;
        }

        int left = burn(root.left, maxTime, start);
        int right = burn(root.right, maxTime, start);

        if(left >= 0 && right >= 0){
            return 1 + Math.max(left, right);
        }

        if(left >= 0){
            int rightBurnDist = Math.abs(right);
            maxTime[0] = Math.max(maxTime[0], rightBurnDist + left);
            return right - 1;
        }

        if(right >= 0){
            int leftBurnDist = Math.abs(left);
            maxTime[0] = Math.max(maxTime[0], leftBurnDist + right);
            return left - 1;
        }

        return Integer.MAX_VALUE;
    }
    private int getHeight(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(getHeight(root.left), getHeight(root.right));
    }
}