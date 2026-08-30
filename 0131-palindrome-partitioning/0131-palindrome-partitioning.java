class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        backtrack(0, s, curr, ans);
        return ans;
    }

    private void backtrack(int ind, String s, List<String> curr, List<List<String>> ans){
        if(ind == s.length()){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i = ind; i < s.length(); i++){
            if(isPalindrome(s, ind, i)){
                curr.add(s.substring(ind, i+1));
                backtrack(i + 1, s, curr, ans);
                curr.remove(curr.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}