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
 class Tuple{
    TreeNode node;
    int row;
    int col;
    public Tuple(TreeNode node, int row, int col){
        this.node = node;
        this.row = row;
        this.col = col;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));

        while(!q.isEmpty()){
            Tuple t = q.poll();
            TreeNode node = t.node;
            int x = t.row;
            int y = t.col;

            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y, new PriorityQueue<>());
            map.get(x).get(y).offer(node.val);

            if(node.left != null) q.offer(new Tuple(node.left, x-1, y+1));
            if(node.right != null) q.offer(new Tuple(node.right, x+1, y+1));
        }

        for(TreeMap<Integer, PriorityQueue<Integer>> level : map.values()){
            List<Integer> column = new ArrayList<>();
            for(PriorityQueue<Integer> nodes : level.values()){
                while(!nodes.isEmpty()){
                    column.add(nodes.poll());
                }
            }
            ans.add(column);
        }
        return ans;
    }
}