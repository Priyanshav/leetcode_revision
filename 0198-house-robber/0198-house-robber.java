class Solution {
    public int rob(int[] nums) {
        int n = nums.length - 1;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return func(n, nums, dp);
    }

    private int func(int n, int[] nums, int[] dp){
        if(n == 0) return nums[0];
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];
        int pick = nums[n] + func(n-2, nums, dp);
        int notPick = func(n-1, nums, dp);
        return dp[n] = Math.max(pick, notPick);
    }
}