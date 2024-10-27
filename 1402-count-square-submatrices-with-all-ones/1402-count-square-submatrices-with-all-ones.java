class Solution {
    public int countSquares(int[][] matrix) {
     int row = matrix.length;
     int col = matrix[0].length;
     int side = row;
     int count =0;
     for(int s=1;s<=side;s++){
        for(int i = 0;i<row;i++){
            for(int j=0;j<col;j++){
                if(isall(matrix,i,j,s)){
                    count++;
                }
            }
        }
     }
     return count;

    }
    private boolean isall(int[][] matrix, int i, int j, int s){
       int row1 = matrix.length;  
        int col1 = matrix[0].length;
         if (i + s - 1 < row1 && j + s -1  < col1) {
            for (int p = i; p < i + s; p++) {
                for (int q = j; q < j + s; q++) {
                    if (matrix[p][q] != 1) {
                        return false;
                    }
                }
            }
        } else {
            return false;
        }
        
        return true;
    }
}