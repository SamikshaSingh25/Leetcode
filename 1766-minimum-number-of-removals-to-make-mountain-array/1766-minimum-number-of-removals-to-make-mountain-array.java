class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        for(int i=0;i<len;i++){
            left[i]=1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    left[i]=Math.max(left[i],left[j]+1);
                }
            }
        }
        for(int i=len-1;i>-1;i--){
            right[i]=1;
            for(int j = len - 1; j > i; j--){
                if(nums[i] > nums[j]){
                    right[i] = Math.max(right[i], right[j] + 1);
                }
            }
        }
        int max=0;
        
        for(int i = 1; i < len - 1; i++){
            if(left[i] > 1 && right[i] > 1){
                max = Math.max(max, left[i] + right[i] - 1);
            }
        }
        
        return len - max;
    }
}