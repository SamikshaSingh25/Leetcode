class Solution {
    public int maximumSum(int[] nums) {
        /* max has a size 82: max value of nums[i] can be 10^9 
        that is 1 000 000 000 the nums[i] with max digit sum can 
        be 0 999 999 999 hence the max possible sum will be 9*9=81 
        hence the array size is taken to be 82 */
        int[] max = new int[82];
        int ans=-1;
        for(int x : nums){
            int sum=0;
            int temp=x;
            while(temp!=0){
                sum+=temp%10;
                temp/=10;
            }
            if(max[sum]!=0){
                ans = Math.max(ans, x+max[sum]);
            }
            max[sum]=Math.max(max[sum],x);
        }
        return ans;
    }
}