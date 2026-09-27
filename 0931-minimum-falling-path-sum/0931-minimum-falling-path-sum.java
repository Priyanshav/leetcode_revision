class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        for(int j = 0; j < m; j++){
            int mini = func(m, n-1, j, matrix, dp);
            ans = Math.min(mini, ans);
        }
        return ans;
    }
    private int func(int m, int i, int j, int[][] matrix, int[][] dp){
        if(j < 0 || j >= m) return (int)1e9;
        if(i == 0) return matrix[0][j];
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        int up = matrix[i][j] + func(m, i-1, j, matrix, dp);
        int ld = matrix[i][j] + func(m, i-1, j-1, matrix, dp);
        int rd = matrix[i][j] + func(m, i-1, j+1, matrix, dp);
        return dp[i][j] = Math.min(up, Math.min(ld, rd));
    }
}