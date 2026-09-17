class Solution {
    public int lengthOfLongestSubstring(String s) {
        /*
        int n = s.length();
        int maxLen = 0;
        for(int i = 0; i < n; i++){
            int[] hash = new int[256];
            for(int j = i; j < n; j++){
                if(hash[s.charAt(j)] == 1) break;
                hash[s.charAt(j)] = 1;
                int len = j - i + 1;
                maxLen = Math.max(len, maxLen);
            }
        }
        return maxLen;
        */
        int n = s.length();
        int[] hash = new int[256];
        Arrays.fill(hash, -1);
        int left = 0, right = 0, maxLen = 0;
        while(right < n){
            if(hash[s.charAt(right)] != -1){
                left = Math.max(hash[s.charAt(right)] + 1, left);
            }
            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);
            hash[s.charAt(right)] = right;
            right++;
        }
        return maxLen;
    }
}