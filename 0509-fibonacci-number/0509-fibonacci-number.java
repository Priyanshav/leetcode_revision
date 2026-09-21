class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        /*
        Arrays.fill(dp, -1);
        return func(n, dp);
        */
        /*
        if(n == 0) return 0;
        if(n == 1) return 1;
        dp[0] = 0;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
        */
        if(n == 0) return 0;
        if(n == 1) return 1;
        int prev1 = 1;
        int prev2 = 0;

        for(int i = 2; i <= n; i++){
            int curr = prev1 + prev2;
            prev2 = prev1;
            prev1 = curr;
        }
        return prev1;
    }
    /*
    private int func(int n, int[] dp){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return dp[n] = func(n-1, dp) + func(n-2, dp);
    }
    */
}