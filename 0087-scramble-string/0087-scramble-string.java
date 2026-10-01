class Solution {
    public boolean isScramble(String s1, String s2) {
        Map<String, Boolean> map = new HashMap<>();
        return solve(s1, s2, map);
    }

    private boolean solve(String s1, String s2, Map<String, Boolean> dp){
        if(s1.equals(s2)) return true;
        if(s1.length() != s2.length()) return false;
        String key = s1 + "#" + s2;
        if(dp.containsKey(key)) return dp.get(key);
        boolean result = false;
        int n = s1.length();
        for(int i = 1; i < n; i++){
            boolean not_swapped = solve(s1.substring(0, i), s2.substring(0, i), dp) && solve(s1.substring(i), s2.substring(i), dp);
            if(not_swapped){
                result = true;
                break;
            }
            boolean swapped = solve(s1.substring(0, i), s2.substring(n-i), dp) && solve(s1.substring(i), s2.substring(0, n-i), dp);
            if(swapped){
                result = true;
                break;
            }
        }
        dp.put(key, result);
        return result;
    }
}