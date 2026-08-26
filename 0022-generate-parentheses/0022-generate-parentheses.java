class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(0, 0, n, "", result);
        return result;
    }
    private void generate(int open, int close, int n, String curr, List<String> result){
        if(open > n) return ;
        if((open + close) == (2*n) && open == close){
            result.add(curr);
            return;
        }
        generate(open + 1, close, n, curr + "(", result);
        if(open > close) generate(open, close+1, n, curr + ")", result);
    }
}