class Solution {
    private int func(int[] arr, int start, int end){
        int prev2 = arr[0];
        int prev1 = 0;
        for(int i = start; i < end; i++){
            int pick = arr[i];
            if(i > 1) pick += prev2;
            int notPick = prev1;
            int curr = Math.max(pick, notPick);
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int n = nums.length-1;
        int ans1 = func(nums, 0, n);
        int ans2 = func(nums, 1, n+1);
        return Math.max(ans1, ans2);
        /*
        int[] temp1 = new int[n];
        int[] temp2 = new int[n];
        for(int i = 0; i <=  n; i++){
            if(i != 0) temp1[i-1] = nums[i];
            if(i != n) temp2[i] = nums[i];
        }
        return Math.max(func(temp1), func(temp2));
        */
        /*
        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int call1 = func(temp1.length - 1, temp1, dp1);
        int call2 = func(temp2.length - 1, temp2, dp2);
        return Math.max(call1, call2);
        */
    }
    /*
    Tabulation
    private int func(int[] arr){
        int n = arr.length - 1;
        int[] dp = new int[n+1];
        dp[0] = arr[0];
        for(int i = 1; i <= n; i++){
            int pick = arr[i];
            if(i > 1) pick += dp[i-2];
            int notPick = dp[i-1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n];
    }
    */
    /*
    Memoization
    private int func(int n, int[] arr, int[] dp){
        if(n < 0) return 0;
        if(n == 0) return arr[n];
        if(dp[n] != -1) return dp[n];

        int pick = arr[n] + func(n-2, arr, dp);
        int notPick = 0 + func(n-1, arr, dp);
        return dp[n] = Math.max(pick, notPick);
    }
    */
}