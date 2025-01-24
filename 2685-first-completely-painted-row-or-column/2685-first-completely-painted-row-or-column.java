class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        //probably tle O(n^3logn)... passes 1055/1058 
        // int rows = mat.length;
        // int cols = mat[0].length;
        // int r = arr.length;
        // int[][] zero = new int[rows][cols];
        // for(int[] z : zero){
        //     Arrays.fill(z,0);
        // }
        // int[] rowp = new int[rows];
        // int[] colp = new int[cols];

        // for(int i=0;i<r;i++){
        //     for(int j = 0;j<rows;j++){
        //         for(int k=0;k<cols;k++){
        //             if(arr[i]==mat[j][k] && zero[j][k]==0){
        //                 zero[j][k]=1;
        //                 rowp[j]++;
        //                 colp[k]++;
        //             }

        //             if(rowp[j]==cols || colp[k]==rows){
        //                 return i;
        //             }
        //         }
        //     }
        // }
        // return -1;



        //optimizing
        int rows = mat.length;
        int cols = mat[0].length;
        int r = arr.length;
        int[] rowp = new int[rows];
        int[] colp = new int[cols];
        
        Map<Integer, int[]> hm = new HashMap<>(); //number and its position

        //ek map banaya to store the position of each number in matrix
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                int val = mat[i][j];
                hm.put(val,new int[]{i,j});
            }
        }

        for(int i=0;i<r;i++){
            int num = arr[i];
            int[] pos = hm.get(num);
            int row = pos[0];
            int col = pos[1];
            rowp[row]++;
            colp[col]++;
            if(rowp[row]==cols || colp[col]==rows){
                return i;
            }
        }
        return -1;

        
    }
}