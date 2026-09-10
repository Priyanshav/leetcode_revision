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
    public List<String> binaryTreePaths(TreeNode root) {
        String curr = "";
        List<String> ans = new ArrayList<>();
        backtrack(root, curr, ans);
        return ans;
    }
    private void backtrack(TreeNode node, String curr, List<String> ans){
        if(node == null) return;
        if(curr.isEmpty()) curr = "" + node.val;
        else curr = curr + "->" + node.val;
        if(node.left == null && node.right == null) ans.add(curr);
        else{
            backtrack(node.left, curr, ans);
            backtrack(node.right, curr, ans);
        }
    }
}