class Solution {
    public double myPow(double x, int n) {
        /*
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
        */
        long temp = n;
        if(n < 0){
            x = 1/x;
            temp = -1L*n;
        }
        if(temp == 0) return 1;
        if(temp % 2 != 0) return x * myPow(x, (int)(temp-1));
        return myPow((x * x), (int) (temp/2));
    }
}