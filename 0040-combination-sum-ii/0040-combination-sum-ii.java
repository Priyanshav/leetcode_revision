class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        backtrack(0, n, candidates, curr, ans, target);
        return ans;
    }

    private void backtrack(int ind, int n, int[] nums, List<Integer> curr, List<List<Integer>> ans, int k){
        if(k == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(k < 0 || ind == n) return;
        curr.add(nums[ind]);
        backtrack(ind + 1, n, nums, curr, ans, k - nums[ind]);
        curr.remove(curr.size() - 1);
        for(int i = ind+1; i < n; i++){
            if(nums[i] != nums[ind]){
                backtrack(i, n, nums, curr, ans, k);
                break;
            }
        }
    }
}