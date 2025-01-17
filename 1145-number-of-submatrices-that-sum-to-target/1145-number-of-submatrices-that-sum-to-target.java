class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int k) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        //only for horizontal sum
        for(int i=0;i<rows;i++){
            for(int j=1;j<cols;j++){
                matrix[i][j]+=matrix[i][j-1];
            }
        }

        int count=0;
        for(int sc = 0; sc<cols;sc++){ //starting column
            for(int j=sc;j<cols;j++){
                Map<Integer, Integer> mp = new HashMap<>();
                mp.put(0,1);
                int sum=0;
                for(int row=0;row<rows;row++){
                    sum+=matrix[row][j]-(sc>0?matrix[row][sc-1]:0);
                    if(mp.containsKey(sum-k)){
                        count+= mp.get(sum-k);
                    }
                    mp.put(sum,mp.getOrDefault(sum,0)+1);
                }
            }
        }
        
        return count;
    }
}