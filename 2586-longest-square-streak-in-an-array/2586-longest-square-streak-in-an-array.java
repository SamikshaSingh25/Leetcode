class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Integer> set = new HashSet<>();
         Arrays.sort(nums);
        // int count=0;
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int maxi=-1;
        // int num = nums[0];
        for(int num:nums){
            if (!set.contains(num)) continue;
            int count=0;
            int curr=num;
            while(set.contains(curr)){ 
                count++;
                set.remove(curr);
                curr=curr*curr;
            }
            // i++;
            maxi = Math.max(maxi,count);
        }
        if(maxi==1){
            return -1;
        }
        return maxi;

    }
}