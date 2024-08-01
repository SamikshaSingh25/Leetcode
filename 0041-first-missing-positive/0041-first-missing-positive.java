class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;

        for(int i=0;i<n;i++){
            int ele = nums[i];
            if(ele>0 && ele<=n){
                int pos = ele-1;
                if(nums[pos]!=ele){
                    int temp = nums[i];
                    nums[i]=nums[pos];
                    nums[pos]=temp;
                    // swap(nums[i],nums[pos]);  //swap is not inbuilt in java
                    i--;   //taki tab tak age na jaye jab tak i ke value pr sahi value na aa jaye
                }
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return n+1;
    }

}