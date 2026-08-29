class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(1, k, n, curr, ans);
        return ans;
    }
    private void backtrack(int elem, int len, int sum, List<Integer> curr, List<List<Integer>> ans){
        if(sum == 0 && curr.size() == len){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(sum < 0 || curr.size() > len) return;
        for(int i = elem; i <= 9; i++){
            if(i <= sum){
                curr.add(i);
                backtrack(i+1, len, sum - i, curr, ans);
                curr.remove(curr.size() - 1);
            }
        }
    }
}