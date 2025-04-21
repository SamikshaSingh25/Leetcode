class Solution {
    public int hammingWeight(int n) {
        // Approach 1 -> log n
        // int c=0;
        // while(n>0){
        //     c+=n%2;
        //     n=n/2;
        // }
        // return c;

        //Approach 2 -> 32iterations
        // int c=0;
        // while(n>0){
        //     n=n&(n-1);
        //     c++;
        // }
        // return c;

        //Approach 3
        int c=0;
        for(int i=0;i<32;i++){
            c+=(n>>i)&1;
        }
        return c;
    } 
}