class Solution {
    public int hammingWeight(int n) {
        // Approach 1
        int c=0;
        while(n>0){
            c+=n%2;
            n=n/2;
        }
        return c;
    } 
}