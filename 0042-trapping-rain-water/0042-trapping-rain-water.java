class Solution {
    public int trap(int[] height) {
        /* int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = height[0];
        for(int i = 1; i < n; i++){
            prefix[i] = Math.max(prefix[i-1], height[i]);
        }

        suffix[n-1] = height[n-1];
        for(int i = n-2; i >= 0; i--){
            suffix[i] = Math.max(suffix[i+1], height[i]);
        }

        int total = 0;
        for(int i = 0; i < n; i++){
            int suffixMax = suffix[i];
            int prefixMax = prefix[i];
            total = total + Math.min(suffixMax, prefixMax) - height[i];
        }
        return total; */

        int n = height.length;
        int left = 0;
        int leftMax = 0;
        int rightMax = 0;
        int right = n-1;
        int total = 0;

        while(left < right){
            if(height[left] <= height[right]){
                if(leftMax > height[left]) total += leftMax - height[left];
                else leftMax = height[left];
                left++;
            }
            else{
                if(rightMax > height[right]) total += rightMax - height[right];
                else rightMax = height[right];
                right--;
            }
        }
        return total;
    }
}