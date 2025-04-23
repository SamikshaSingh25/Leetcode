class Solution {
    public int bitwiseComplement(int n) {
        if(n==0) return 1;
       return ((Integer.highestOneBit(n)<<1)-1)^n; 
    }
}