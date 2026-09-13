/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int currDist = 0;

        while(!q.isEmpty()){
            TreeNode node = q.poll();

            if(node.left != null){
                map.put(node.left, node);
                q.add(node.left);
            }
            if(node.right != null){
                map.put(node.right, node);
                q.add(node.right);
            }
        }

        List<Integer> ans = new ArrayList<>();
        Set<TreeNode> visited = new HashSet<>();
        q.add(target);
        visited.add(target);

        while(!q.isEmpty()){
            if(currDist == k){
                while(!q.isEmpty()){
                    ans.add(q.poll().val);
                }
                return ans;
            }
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();

                if(node.left != null && !visited.contains(node.left)){
                    visited.add(node.left);
                    q.add(node.left);
                }
                if(node.right != null && !visited.contains(node.right)){
                    visited.add(node.right);
                    q.add(node.right);
                }
                if(map.containsKey(node) && !visited.contains(map.get(node))){
                    visited.add(map.get(node));
                    q.add(map.get(node));
                }
            }
            currDist++;
        }
        return ans;
    }
}