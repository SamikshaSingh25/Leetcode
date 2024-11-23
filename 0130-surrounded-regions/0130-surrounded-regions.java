class Node{
    int i;
    int j;
    Node(int i, int j){
        this.i=i;
        this.j=j;
    }

}

class Solution {
    int[][] dir = new int[][] {{-1,0},{0,-1},{0,1},{1,0}};
    private boolean isValid(int row, int col, int rows, int cols){
        if(row>=0 && row<rows && col>=0 && col<cols){
            return true;
        }
        else{
            return false;
        }
    }
    public void solve(char[][] board) {
        
        int rows = board.length;
        int cols = board[0].length;
        Queue<Node> q = new LinkedList<>();
        for(int i = 0; i<rows; i++){
            for(int j=0;j<cols;j++){
                if((i==0 || i==rows-1 || j==0 || j==cols-1)&& board[i][j]=='O'){  //entry point
                    
                        q.add(new Node(i,j));
                        board[i][j]='V';
                    
                } 
            }
        }

        while(!(q.isEmpty())){
            Node node = q.poll();
            for(int[] d : dir){
                int newr = node.i + d[0];
                int newc = node.j + d[1];
                if(isValid(newr,newc,rows,cols) && board[newr][newc]=='O'){
                    q.add(new Node(newr,newc));
                    board[newr][newc] = 'V';
                }
            }
        }
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
               if(board[i][j]=='V'){
                board[i][j]='O';
               }
               else{
                board[i][j]='X';
               } 
            }
        }
          
    }

}