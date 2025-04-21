class Solution {
    public int[] countBits(int n) {
        //with builtin function -> the question explicitly says not to use it
        // int res[] = new int[n+1];
        // for(int i=0;i<=n;i++){
        //     res[i]=Integer.bitCount(i);
        // }
        // return res;

        //Approach 2
        int res[] = new int[n+1];
        res[0]=0;
        for(int i=1;i<=n;i++){
            if(i%2!=0){
                res[i]=res[i/2]+1;
            }
            else{
                res[i]=res[i/2];
            }
        }
        return res;
    }
}