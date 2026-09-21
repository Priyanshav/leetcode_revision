class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return func(n, dp);
    }
    private int func(int n, int[] dp){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return dp[n] = func(n-1, dp) + func(n-2, dp);
    }
}