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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> inmap = new HashMap<>();
        for(int i=0;i<inorder.length; i++){
            inmap.put(inorder[i], i);
        }
        TreeNode root = helper(inorder,0,inorder.length-1, postorder,0, postorder.length-1, inmap);

        return root;
    }
    private TreeNode helper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd, HashMap<Integer, Integer> inmap){
        if(inStart > inEnd || postStart > postEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inroot = inmap.get(root.val);
        int numsLeft = inroot - inStart;

        root.left = helper(inorder, inStart,inroot-1, postorder,postStart, postStart + numsLeft - 1, inmap);

        root.right = helper(inorder, inroot + 1, inEnd, postorder, postStart+numsLeft , postEnd -1, inmap );

        return root;
    }
}