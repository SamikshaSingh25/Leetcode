class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length;
        int c1=1;
        int maxi=1;
        int i=0,j=1;
        //increasing
        while(j<n){
            if(nums[i]<nums[j]){
                c1++;
            }
            else{
                c1=1;
            }
            i++;
            j++;
            maxi=Math.max(maxi,c1);
        }
        //decreasing
        i=0;
        j=1;
        c1=1;
        int mini=0;
        while(j<n){
            if(nums[i]>nums[j]){
                c1++;
            }
            else{
                c1=1;
            }
            i++;
            j++;
            mini=Math.max(mini,c1);
        }
        return Math.max(maxi,mini);
        
    }
}