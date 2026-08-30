class Solution {
    public List<String> letterCombinations(String digits) {
        String[] combo = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> ans = new ArrayList<>();
        backtrack(0, "", digits, combo, ans);
        return ans;
    }
    private void backtrack(int ind, String curr, String digits, String[] combo, List<String> ans){
        if(ind == digits.length()){
            ans.add(curr);
            return;
        }
        String s = combo[digits.charAt(ind) - '0'];
        for(int i = 0; i < s.length(); i++){
            backtrack(ind + 1, curr + s.charAt(i), digits, combo, ans);
        }
    }
}