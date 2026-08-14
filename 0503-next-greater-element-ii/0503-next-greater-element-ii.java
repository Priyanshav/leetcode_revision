class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 2*n-1; i >= 0; i--){
            int ind = i%n;
            int currEle = nums[ind];
            while(!st.isEmpty() && st.peek() <= currEle) st.pop();
            if(i < n){
                if(st.isEmpty()) res[i] = -1;
                else res[i] = st.peek();
            }
            st.push(nums[ind]);
        }
        return res;
    }
}