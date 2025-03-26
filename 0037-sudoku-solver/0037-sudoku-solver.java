class Solution {
    public void solveSudoku(char[][] board) {
        helper(board, 0, 0);   
    }

    boolean helper(char[][] board, int i, int j){
        if(i==9) return true;

        int ni = (j==8)?i+1:i;
        int nj = (j==8)?0:j+1;
        if(board[i][j] !='.'){
            return helper(board, ni,nj);
        }
        else{
            for(int po = 1; po<=9 ; po++){
                char num = (char)(po+'0');
                if(isValid(board,i,j,num)){
                    board[i][j]=num;
                    //recursion
                    if(helper(board, ni, nj)) return true;
                    //backtrack
                    board[i][j]='.';
                }
            }
            return false;
        }
    }
    public boolean isValid(char[][] board, int x, int y, char num){
        //row
        for(int j=0;j<9;j++){
            if(board[x][j] == num) return false;
        }
        //col
        for(int i=0;i<9;i++){
            if(board[i][y] == num) return false;
        }
        //box
        int si = x/3*3;
        int sj = y/3*3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[si+i][sj+j]==num) return false;
            }
        }
        return true;
    }
}