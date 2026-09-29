class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        return func(0, 0, triangle, dp, n);
    }

    private int func(int i, int j, List<List<Integer>> triangle, int[][] dp, int n){
        if(i == n-1) return triangle.get(i).get(j);
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        int down = triangle.get(i).get(j) + func(i + 1, j, triangle, dp, n);
        int dd = triangle.get(i).get(j) + func(i + 1, j + 1, triangle, dp, n);
        return dp[i][j] = Math.min(down, dd);
    }
}