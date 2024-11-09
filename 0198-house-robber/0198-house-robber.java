//recursive method
/* class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        return helper(nums,n);
    }
    private int helper(int[] nums,int n){
        if(n<=0){
            return 0;
        }
        else{
            return Math.max(nums[n-1]+helper(nums, n-2), helper(nums, n-1));
        }
    }
}
*/

//memoization 
class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(nums,n,dp);
    }
    private int helper(int[] nums, int n,int[] dp){
        if(n<=0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        
        else{
            return dp[n] = Math.max(helper(nums,n-1,dp),nums[n-1]+helper(nums,n-2,dp));
        }
    }
}