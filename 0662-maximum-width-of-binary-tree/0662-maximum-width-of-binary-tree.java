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

class Pair{
    TreeNode node;
    int ind;
    public Pair(TreeNode node, int ind){
        this.node = node;
        this.ind = ind;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        int ans = 0;
        q.offer(new Pair(root, 0));

        while(!q.isEmpty()){
            int min = q.peek().ind;
            int first = 0, last = 0;
            int size = q.size();

            for(int i = 0; i < size; i++){
                int curr_id = q.peek().ind - min;
                TreeNode node = q.poll().node;
                if(i == 0) first = curr_id;
                if(i == size-1) last = curr_id;
                if(node.left != null) q.offer(new Pair(node.left, curr_id * 2 + 1));
                if(node.right != null) q.offer(new Pair(node.right, curr_id * 2 + 2));
                ans = Math.max(ans, last - first + 1);
            }
        }
        return ans;
    }
}