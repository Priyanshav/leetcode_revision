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
        if(inorder.length != postorder.length) return null;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        TreeNode root = buildTree(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1, map);
        return root;
    }

    private TreeNode buildTree(int[] postorder, int poststart, int postend, int[] inorder, int instart, int inend, Map<Integer, Integer> map){
        if(poststart > postend || instart > inend) return null;

        TreeNode root = new TreeNode(postorder[postend]);
        int inroot = map.get(root.val);
        int numsleft = inroot - instart;

        root.left = buildTree(postorder, poststart, poststart + numsleft - 1, inorder, instart, inroot - 1, map);
        root.right = buildTree(postorder, poststart + numsleft, postend - 1, inorder, inroot + 1, inend, map);

        return root;
    }
}