class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n][2];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        } 
        return func(0, nums, 0, dp);
    }
    private long func(int ind, int[] nums, int flag, long[][] dp){
        if(ind == nums.length) return 0;
        if(dp[ind][flag] != -1) return dp[ind][flag];
        long skip = func(ind + 1, nums, flag, dp);
        long val = nums[ind];
        if(flag == 1) val = -val;
        long take = func(ind + 1, nums, 1 - flag, dp) + val;
        return dp[ind][flag] = Math.max(skip, take);
    }
}