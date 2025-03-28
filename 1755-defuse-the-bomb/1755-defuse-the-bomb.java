class Solution {
    public int[] decrypt(int[] code, int k) {
        int n=code.length;
        int[] res = new int[n];
        if(k==0){
            return res;
        }
        for(int i=0;i<n;i++){
            if(k>0){
                for(int j=i+1;j<=i+k;j++){
                    res[i]+=code[j%n];
                }
            }
            if(k<0){
                for(int j=i-Math.abs(k);j<i;j++){
                    res[i]+=code[(j+n)%n];
                }
            }
        }
        return res;
    }
}