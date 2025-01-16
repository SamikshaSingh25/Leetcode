class Solution {
    public int subarraySum(int[] nums, int k) {
        //Brute TL:(O^3) most probably
        int n = nums.length;
        int sum=0;
        int c=0;
        for(int i=0;i<n;i++){
            sum=0;
            for(int j=i;j<n;j++){
               sum+=nums[j];
               if(sum==k){
                c++;
               }
            }
        }
        // for(int i=0;i<n;i++)
        //     if(nums[i]==k){
        //         c++;
        //     }
        // }
        return c;
    }
}