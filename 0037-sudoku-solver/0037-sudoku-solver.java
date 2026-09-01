class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);
    }       

    private boolean backtrack(char[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.'){
                    for(char digit = '1'; digit <= '9'; digit++){
                        if(rulesCheck(i, j, digit, board)){
                            board[i][j] = digit;
                            if(backtrack(board)) return true;
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean rulesCheck(int row, int col, char digit, char[][] board){
        for(int i = 0; i < 9; i++){
            if(board[i][col] == digit || board[row][i] == digit) return false;
        }
        int startRow = (row/3)*3;
        int startCol = (col/3)*3;
        for(int i = startRow; i < startRow+3; i++){
            for(int j = startCol; j < startCol+3; j++){
                if(board[i][j] == digit) return false;
            }
        }
        return true;
    }
}