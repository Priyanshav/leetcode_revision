class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(word.charAt(0) == board[i][j]){
                    if(backtrack(0, i, j, word, board)) return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(int ind, int i, int j, String word, char[][] board){
        if(ind == word.length()) return true;

        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length || word.charAt(ind) != board[i][j]) return false;

        char temp = board[i][j];
        board[i][j] = ' ';

        boolean ans = backtrack(ind + 1, i + 1, j, word, board) ||
                        backtrack(ind + 1, i - 1, j, word, board) ||
                        backtrack(ind + 1, i, j + 1, word, board) ||
                        backtrack(ind + 1, i, j - 1, word, board);

        board[i][j] = temp;
        return ans;
    }
}