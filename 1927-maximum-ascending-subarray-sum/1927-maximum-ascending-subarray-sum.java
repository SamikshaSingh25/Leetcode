class Solution {
    public int maxAscendingSum(int[] nums) {
        int n = nums.length;
        int i=0;
        int j=1;
        int sum=nums[0];
        int maxi=0;
        if(n<2){
            return sum;
        }
        while(j<n && i<n){  
            maxi=Math.max(sum,maxi);
            if(nums[i]<nums[j]){
                sum+=nums[j];
            }
            else{
                sum=nums[j];
            }
            System.out.println("nums[i]:"+nums[i]+" num[j]:"+nums[j]+ " sum: "+sum);
            maxi=Math.max(sum,maxi);
            i++;
            j++;
        }
        return maxi;
    }
}
            // if(nums[i]<nums[j]){
            //     sum+=nums[j];
            //     System.out.println("nums[i]:"+nums[i]+" num[j]:"+nums[j]+ " sum: "+sum);
            //     j++;
            // }
            // else {
            //     // System.out.println("num[j]3:"+nums[j]+ " sum3: "+sum);
            //     i++;
            //     j=i+1;
            //     sum=nums[i];
                
            // }
            // maxi=Math.max(maxi,sum);