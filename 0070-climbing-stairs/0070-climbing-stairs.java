class Solution {
    public int climbStairs(int n) {
        int first = 1;
        int second = 1;
        int i=0;
        int third=0;
        while(i<n){
            third = first + second;
            first = second;
            second = third;
            i++;
        }
        return first;

    }
}