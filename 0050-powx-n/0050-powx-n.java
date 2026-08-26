class Solution {
    public double myPow(double x, int n) {
        if(n == 0 || x == 1.0) return 1;
        double ans = 1;
        long temp = n;
        if(n < 0){
            x = 1/x;
            temp = -1L * n;
        }
        while(temp > 0){
            if(temp % 2 != 0){
                ans *= x;
                temp = temp-1;
            }
            else{
                x = x*x;
                temp = temp/2;
            }
        }
        return ans;
    }
}