class Solution {
    public int rob(int[] nums) {
        int n = nums.length - 1;
        int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return func(n, nums, dp);
        /*
        dp[0] = nums[0];
        if(nums.length == 1) return dp[0];
        dp[1] = Math.max(dp[0], nums[1]);
        if(nums.length == 2) return dp[1];
        for(int i = 2; i <= n; i++){
            int pick = nums[i] + dp[i-2];
            int notPick = 0 + dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n];
        */
        int prev2 = nums[0];
        if(nums.length == 1) return prev2;
        int prev1 = Math.max(nums[1], prev2);
        if(nums.length == 2) return prev1;

        for(int i = 2; i <= n; i++){
            int pick = nums[i] + prev2;
            int notPick = prev1;
            int curr = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    /*
    private int func(int n, int[] nums, int[] dp){
        if(n == 0) return nums[0];
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];
        int pick = nums[n] + func(n-2, nums, dp);
        int notPick = func(n-1, nums, dp);
        return dp[n] = Math.max(pick, notPick);
    }
    */
}