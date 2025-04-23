class Solution {
    public int bitwiseComplement(int n) {
        //1st Approach
    //     if(n==0) return 1;
    //    return ((Integer.highestOneBit(n)<<1)-1)^n; 

       //2nd Approach
       int l = Integer.toBinaryString(n).length();
       int v=1<<l;
       int mask = v-1;
       return mask^n;
    }
}