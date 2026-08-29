class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0, n, nums, curr, ans);
        return ans;
    }
    private void backtrack(int ind, int n, int[] nums, List<Integer> curr, List<List<Integer>> ans){
        if(ind == n){
            ans.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[ind]);
        backtrack(ind + 1, n, nums, curr, ans);
        curr.remove(curr.size() - 1);
        for(int i = ind + 1; i < n; i++){
            if(nums[i] != nums[ind]){
                backtrack(i, n, nums, curr, ans);
                return;
            }
        }
        backtrack(n, n, nums, curr, ans);
    }
}