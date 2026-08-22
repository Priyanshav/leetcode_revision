class Solution {
    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        boolean result = false;
        while(low <= high){
            int mid = (low + high) / 2;
            long prod = findProd(mid, 2, num);
            if(prod == num){
                result = true;
                break;
            }
            else if(prod > num) high = mid - 1;
            else low = mid + 1;
        }
        return result;
    }
    public long findProd(int mid, int N, int num){
        long prod = 1;
        for(int i = 0; i < N; i++){
            prod *= mid;
            if(prod > num) return (long) num+1;
        }
        return prod;
    }
}