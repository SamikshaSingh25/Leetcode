class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n=nums.length;
        int[] ans =  new int[n-k+1];

        for(int i=0;i<n-k+1;i++){
            boolean isconandsort=true;
            for(int j=i;j<i+k-1;j++){
                if(nums[j+1]!=nums[j]+1){ //consecutive hona chiyr isliye
                    isconandsort=false;
                    break;
                }   
            }
            if(isconandsort){
                ans[i] = nums[i+k-1];
            }
            else{
                ans[i]=-1;
            }
        }
        return ans;
    }
}