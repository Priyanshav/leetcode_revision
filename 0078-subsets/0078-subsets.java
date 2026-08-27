class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(0, n, nums, curr, ans);
        return ans;
    }
    private void backtrack(int ind, int n, int[] nums, List<Integer> curr, List<List<Integer>> ans){
        if(ind == n){
            ans.add(new ArrayList<>(curr));
            return;
        }
        backtrack(ind+1, n, nums, curr, ans);
        curr.add(nums[ind]);
        backtrack(ind+1, n, nums, curr, ans);
        curr.remove(curr.size() - 1);
    }
}