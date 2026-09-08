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
    public boolean isSymmetric(TreeNode root) {
        return root == null || backtrack(root.right, root.left);
    }
    private boolean backtrack(TreeNode right, TreeNode left){
        if(right == null || left == null) return right == left;
        if(right.val != left.val) return false;
        return backtrack(right.right, left.left) && backtrack(right.left, left.right);
    }
}