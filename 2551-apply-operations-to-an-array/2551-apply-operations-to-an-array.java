class Solution {
    public int[] applyOperations(int[] nums) {
        int n = nums.length;
        for(int i=1;i<n;i++){
            if(nums[i-1] == nums[i]){
                nums[i-1] = nums[i] * 2;
                nums[i] = 0;
            }
        }
        int [] result = new int [n];
        int idx = 0;
        for(int i = 0;i<n;i++){
            if(nums[i] != 0){
                result[idx++] = nums[i];
            }
        }
        return result;
    }
}