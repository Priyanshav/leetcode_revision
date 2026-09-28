class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n][2];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        } 
        return func(0, nums, true, dp);
    }
    private long func(int ind, int[] nums, boolean flag, long[][] dp){
        if(ind == nums.length) return 0;
        if(dp[ind][flag ? 1 : 0] != -1) return dp[ind][flag ? 1 : 0];
        long skip = func(ind + 1, nums, flag, dp);
        long val = nums[ind];
        if(!flag) val = -val;
        long take = func(ind + 1, nums, !flag, dp) + val;
        return dp[ind][flag ? 1 : 0] = Math.max(skip, take);
    }
}