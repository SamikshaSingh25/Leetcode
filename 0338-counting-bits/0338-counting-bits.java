class Solution {
    public int[] countBits(int n) {
        //with builtin function -> the question explicitly says not to use it
        int res[] = new int[n+1];
        for(int i=0;i<=n;i++){
            res[i]=Integer.bitCount(i);
        }
        return res;
    }
}