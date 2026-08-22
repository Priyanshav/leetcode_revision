class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        if(k > n) return -1;
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += nums[i];
            maxi = Math.max(maxi, nums[i]);
        }
        int low = maxi;
        int high = sum;
        while(low <= high){
            int mid = (low + high) / 2;
            boolean result = subArrays(nums, mid, k);
            if(!result) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
    
    public boolean subArrays(int[] nums, int mid, int k){
        int subArrayCount = 1;
        int subArrayElem = 0;
        for(int i = 0; i < nums.length; i++){
            if(subArrayElem + nums[i] <= mid) subArrayElem += nums[i];
            else{
                subArrayElem = nums[i];
                subArrayCount++;
            }
        }
        return subArrayCount <= k;
    }
}