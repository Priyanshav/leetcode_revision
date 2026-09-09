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
/*
class Pair{
    TreeNode node;
    int level;

    public Pair(TreeNode node, int level){
        this.node = node;
        this.level = level;
    }
 }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        /*
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair p = q.poll();
            TreeNode node = p.node;
            int level = p.level;
            map.put(level, node.val);
            if(node.left != null) q.offer(new Pair(node.left, level + 1));
            if(node.right != null) q.offer(new Pair(node.right, level + 1));
        }
        for(Integer values : map.values()) ans.add(values);
        return ans;
        */
        backtrack(root, 0, ans);
        return ans;
    }
    private void backtrack(TreeNode node, int level, List<Integer> ans){
        if(node == null) return ;
        if(level == ans.size()) ans.add(node.val);
        backtrack(node.right, level+1, ans);
        backtrack(node.left, level+1, ans);
    }
}