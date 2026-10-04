class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] result = new long[k];
        long[] prevCount = new long[k];

        for(int i = 0; i < n; i++){
            long[] currCount = new long[k];
            int currElemRem = nums[i] % k;
            currCount[currElemRem]++;
            for(int oldRem = 0; oldRem < k; oldRem++){
                int newRemain =(int) ((long)oldRem * nums[i] % k);

                currCount[newRemain] += prevCount[oldRem];
            }
            prevCount = currCount;
            for(int x = 0; x < k; x++){
                result[x] += prevCount[x];
            }
        }
        return result;
    }
}